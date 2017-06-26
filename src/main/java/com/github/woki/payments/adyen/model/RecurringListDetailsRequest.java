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
package com.github.woki.payments.adyen.model;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @author Willian Oki &lt;willian.oki@gmail.com&gt;
 */
@SuppressWarnings("serial")
@Getter
@Setter
public class RecurringListDetailsRequest implements Serializable {
    private String merchantAccount;
    private ContractType contract;
    private String shopperReference;

    public RecurringListDetailsRequest() {
    }

    public RecurringListDetailsRequest(String merchantAccount, ContractType contract, String shopperReference) {
        this.merchantAccount = merchantAccount;
        this.contract = contract;
        this.shopperReference = shopperReference;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
                .append("merchantAccount", merchantAccount)
                .append("contract", contract)
                .append("shopperReference", shopperReference).toString();
    }
}
