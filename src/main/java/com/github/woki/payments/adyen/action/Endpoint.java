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
package com.github.woki.payments.adyen.action;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.woki.payments.adyen.ClientConfig;
import com.github.woki.payments.adyen.model.Card;
import com.github.woki.payments.adyen.model.Error;
import com.github.woki.payments.adyen.model.PaymentRequest;
import com.github.woki.payments.adyen.support.APService;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Map;

import static org.apache.http.client.fluent.Request.Post;

/**
 * @author Willian Oki &lt;willian.oki@gmail.com&gt;
 */
final class Endpoint {

    private Endpoint() {
        // utility
    }

    private static final Logger LOG = LoggerFactory.getLogger(Endpoint.class);
    private static final ObjectMapper MAPPER = new ObjectMapper();

    private static Request createPost(APService service, ClientConfig config, Object request) {
        Request retval = Post(config.getEndpointPort(service));
        // configure conn timeout
        retval.connectTimeout(config.getConnectionTimeout());
        // configure socket timeout
        retval.socketTimeout(config.getSocketTimeout());
        // add json
        retval.addHeader("Content-Type", "application/json");
        retval.addHeader("Accept", "application/json");
        for (Map.Entry<String, String> entry : config.getExtraParameters().entrySet()) {
            retval.addHeader(entry.getKey(), entry.getValue());
        }
        // add content
        String bodyString;
        try {
            bodyString = MAPPER.writeValueAsString(encrypt(config, request));
        } catch (Exception e) {
            throw new RuntimeException("CSE/JSON serialization error", e);
        }
        retval.bodyString(bodyString, ContentType.APPLICATION_JSON);
        if (config.hasProxy()) {
            retval.viaProxy(config.getProxyHost());
        }
        return retval;
    }

    private static Executor createExecutor(ClientConfig config) {
        Executor retval = Executor.newInstance();
        retval.auth(config.getEndpointHost(), config.getUsername(), config.getPassword());
        if (config.hasProxy() && config.isProxyAuthenticated()) {
            retval.auth(config.getProxyHost(), config.getProxyUsername(), config.getProxyPassword());
        }
        return retval;
    }

    private static <ReqType> Request createRequest(final ClientConfig config, final ReqType request, final Options opts) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("config: {}, request: {}, options: {}", config, request, opts);
        }
        Request retval = Endpoint.createPost(APService.from(request, opts), config, request);
        if (LOG.isDebugEnabled()) {
            LOG.debug("retval: {}", retval);
        }
        return retval;
    }

    @SuppressWarnings("unchecked")
    private static <ResType extends Error> ResType handleResponse(final HttpResponse response, final Class<ResType> responseClass) throws IOException {
        ResType retval;
        HttpOutcome httpOutcome = handleHttpResponse(response, responseClass);
        if (httpOutcome.content != null) {
            retval = (ResType) httpOutcome.content;
        } else {
            if (httpOutcome.statusCode != HttpStatus.SC_OK) {
                LOG.warn("{} handling failed: {} - {}", responseClass.getSimpleName(), httpOutcome.statusCode, httpOutcome.message);
            }
            try {
                retval = responseClass.newInstance();
                retval.setStatus(httpOutcome.statusCode);
                retval.setMessage(httpOutcome.message);
            } catch (InstantiationException | IllegalAccessException e) {
                LOG.error("{} instantiation failure", responseClass.getSimpleName());
                throw new IOException(e);
            }
        }
        return retval;
    }

    static <ResType extends Error, ReqType> ResType invoke(final ClientConfig config, final ReqType request, final Class<ResType> responseClass,
                                                           final Options opts) throws IOException {
        Request httpRequest = createRequest(config, request, opts);
        Executor invoker = createExecutor(config);
        return invoker
                .execute(httpRequest)
                .handleResponse(
                    new ResponseHandler<ResType>() {
                        public ResType handleResponse(HttpResponse response) throws IOException {
                            ResType res = Endpoint.handleResponse(response, responseClass);
                            if (LOG.isDebugEnabled()) {
                                LOG.debug("response: {}", res);
                            }
                            return res;
                        }
                    }
                );
    }

    static <ResType extends Error, ReqType> ResType invoke(final ClientConfig config, final ReqType request, final Class<ResType> responseClass)
            throws IOException {
        return invoke(config, request, responseClass, null);
    }

    private static <ResType extends Error> HttpOutcome handleHttpResponse(final HttpResponse response, final Class<ResType> responseClass) {
        final HttpOutcome<ResType> retval = new HttpOutcome<>();
        final StatusLine status = response.getStatusLine();
        final HttpEntity entity = response.getEntity();
        try {
            retval.content = MAPPER.readValue(new InputStreamReader(entity.getContent()), responseClass);
        } catch (IOException e) {
            LOG.warn("Could no deserialize JSON from entity", e);
        }
        retval.statusCode = status.getStatusCode();
        switch (status.getStatusCode()) {
            case HttpStatus.SC_OK:
                retval.message = "Request processed normally";
                break;
            case HttpStatus.SC_BAD_REQUEST:
                retval.message = "Problem reading or understanding request";
                break;
            case HttpStatus.SC_UNPROCESSABLE_ENTITY:
                retval.message = "Request validation error";
                break;
            case HttpStatus.SC_UNAUTHORIZED:
                retval.message = "Authentication required";
                break;
            case HttpStatus.SC_FORBIDDEN:
                retval.message = "Insufficient permission to process request";
                break;
            case HttpStatus.SC_NOT_FOUND:
                retval.message = "Service not found";
                break;
            default:
                retval.message = "Unexpected error";
        }
        if (retval.content != null && StringUtils.isEmpty(retval.content.getMessage()))
            retval.content.setMessage(retval.message);
        return retval;
    }

    private static class HttpOutcome<ResType> {
        int statusCode;
        String message;
        ResType content;
    }

    private static Object encrypt(ClientConfig config, Object original) throws BadPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, InvalidAlgorithmParameterException, InvalidKeyException, IllegalArgumentException, JsonProcessingException {
        if (! (original instanceof PaymentRequest)) {
            return original;
        }
        if (StringUtils.isBlank(config.getEncryptionKey())) {
            LOG.debug("CSE not enabled");
            return original;
        }
        Card card = ((PaymentRequest) original).getCard();
        if (card == null) {
            LOG.debug("CSE cannot be used: no card to encrypt");
            return original;
        }
        card.setGenerationtime(new Date());
        String jsonCard = MAPPER.writeValueAsString(card);
        String encryptedCard = CSEUtil.encrypt(config.getAesCipher(), config.getRsaCipher(), jsonCard);
        ((PaymentRequest) original).setCard(null);
        ((PaymentRequest) original).addAdditionalDataEntry(Card.CARD_ENCRYPTED_ADDITIONAL_DATA_KEY_NAME, encryptedCard);
        return original;
    }
}
