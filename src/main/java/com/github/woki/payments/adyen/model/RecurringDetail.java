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
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Willian Oki &lt;willian.oki@gmail.com&gt;
 */
@SuppressWarnings("serial")
@Getter
@Setter
public class RecurringDetail implements Serializable {
    private String recurringDetailReference;
	private String name;
	private String variant;
	private String paymentMethodVariant;
	private Card card;
	private ELV elv;
	private BankAccount bank;
	private TokenDetails tokenDetails;
	private Name shopperName;
	private String socialSecurityNumber;
	private Address billingAddress;
	private String alias;
	private String aliasType;
	private String firstPspReference;
	private Date creationDate;
	private Map<String, String> additionalData;
	private List<String> contractTypes;
	private String acquirer;
	private String acquirerAccount;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
                .append("recurringDetailReference", recurringDetailReference)
                .append("name", name)
                .append("variant", variant)
                .append("paymentMethodVariant", paymentMethodVariant)
                .append("card", card)
                .append("elv", elv)
                .append("bank", bank)
                .append("tokenDetails", tokenDetails)
                .append("shopperName", shopperName)
                .append("socialSecurityNumber", socialSecurityNumber)
                .append("billingAddress", billingAddress)
                .append("alias", alias)
                .append("aliasType", aliasType)
                .append("firstPspReference", firstPspReference)
                .append("creationDate", creationDate)
                .append("additionalData", additionalData)
                .append("contractTypes", contractTypes)
                .append("acquirer", acquirer)
                .append("acquirerAccount", acquirerAccount).toString();
    }
}
