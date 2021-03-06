/*
 * Copyright 2015 Willian Oki
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package com.github.woki.payments.adyen;

import com.github.woki.payments.adyen.action.*;
import com.github.woki.payments.adyen.model.*;

import java.util.Map;

/**
 * @author Willian Oki &lt;willian.oki@gmail.com&gt;
 */
public final class Client implements IClient {
    private ClientConfig config;

    private Client() {
        // disable default constructor
    }

    public interface IBuilder {
        IBuilder timeout(long connectionTimeout, long readTimeout);

        IBuilder connectionTimeout(long timeout);

        IBuilder readTimeout(long timeout);

        IBuilder extraParameters(final Map<String, String> extraParameters);

        IBuilder proxyConfig(final String config);

        IBuilder encryptionKey(final String encryptionKey);

        IBuilder addExtraParameter(final String key, final String value);

        Client build();
    }

    public static IAccount endpoint(final String endpoint) {
        return new Builder(endpoint);
    }

    public interface IAccount {
        IBuilder credentials(final String username, final String password);
    }

    private static final class Builder implements IAccount, IBuilder {
        private Client instance = new Client();

        private Builder() {
            // disable default constructor
        }

        Builder(final String endpoint) {
            instance.config = new ClientConfig(endpoint);
        }

        @Override
        public IBuilder timeout(long connectionTimeout, long readTimeout) {
            instance.config.setConnectionTimeout((int) connectionTimeout);
            instance.config.setSocketTimeout((int) readTimeout);
            return this;
        }

        @Override
        public IBuilder connectionTimeout(long timeout) {
            instance.config.setConnectionTimeout((int) timeout);
            return this;
        }

        @Override
        public IBuilder readTimeout(long timeout) {
            instance.config.setSocketTimeout((int) timeout);
            return this;
        }

        @Override
        public IBuilder extraParameters(final Map<String, String> extraParameters) {
            instance.config.setExtraParameters(extraParameters);
            return this;
        }

        @Override
        public IBuilder proxyConfig(final String config) {
            instance.config.setProxyConfig(config);
            return this;
        }

        @Override
        public IBuilder encryptionKey(final String encryptionKey) {
            instance.config.setEncryptionKey(encryptionKey);
            return this;
        }

        @Override
        public IBuilder addExtraParameter(final String key, final String value) {
            instance.config.addExtraParameter(key, value);
            return this;
        }

        @Override
        public Client build() {
            return instance;
        }

        @Override
        public IBuilder credentials(final String username, final String password) {
            instance.config.setUsername(username);
            instance.config.setPassword(password);
            return this;
        }
    }

    @Override
    public ClientConfig getClientConfig() {
        return config;
    }

    @Override
    public PaymentResponse authorise(final PaymentRequest request) {
        return Authorise.execute(config, request, false);
    }

    @Override
    public PaymentResponse authorise3ds(final PaymentRequest request) {
        return Authorise.execute(config, request, true);
    }

    @Override
    public PaymentResponse verifyBin(final PaymentRequest request) {
        return Authorise.execute(config, request, false);
    }

    @Override
    public ModificationResponse capture(final ModificationRequest request) {
        return Capture.execute(config, request);
    }

    @Override
    public ModificationResponse cancel(final ModificationRequest request) {
        return Cancel.execute(config, request);
    }

    @Override
    public ModificationResponse refund(final ModificationRequest request) {
        return Refund.execute(config, request);
    }

    @Override
    public ModificationResponse cancelOrRefund(final ModificationRequest request) {
        return CancelOrRefund.execute(config, request);
    }

    @Override
    public RecurringDisableResponse recurringDisable(final RecurringDisableRequest request) {
        return RecurringDisable.execute(config, request);
    }

    @Override
    public RecurringListDetailsResponse recurringListDetails(final RecurringListDetailsRequest request) {
        return RecurringListDetails.execute(config, request);
    }
}
