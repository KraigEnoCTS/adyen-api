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

import com.github.woki.payments.adyen.support.ToStringStyle;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * @author Willian Oki &lt;willian.oki@gmail.com&gt;
 */
@SuppressWarnings("serial")
public class RecurringDisableRequest implements Serializable {
    private String contract;
    private String merchantAccount;
    private String recurringDetailReference;
    private String shopperReference;

    public RecurringDisableRequest() {
    }

    public RecurringDisableRequest(String contract, String merchantAccount, String recurringDetailReference, String shopperReference) {
        this.contract = contract;
        this.merchantAccount = merchantAccount;
        this.recurringDetailReference = recurringDetailReference;
        this.shopperReference = shopperReference;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public String getMerchantAccount() {
        return merchantAccount;
    }

    public void setMerchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
    }

    public String getRecurringDetailReference() {
        return recurringDetailReference;
    }

    public void setRecurringDetailReference(String recurringDetailReference) {
        this.recurringDetailReference = recurringDetailReference;
    }

    public String getShopperReference() {
        return shopperReference;
    }

    public void setShopperReference(String shopperReference) {
        this.shopperReference = shopperReference;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
                .append("contract", contract)
                .append("merchantAccount", merchantAccount)
                .append("recurringDetailReference", recurringDetailReference)
                .append("shopperReference", shopperReference).toString();
    }
}
