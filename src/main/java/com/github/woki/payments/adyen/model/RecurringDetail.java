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

    public String getRecurringDetailReference() {
        return recurringDetailReference;
    }

    public void setRecurringDetailReference(String recurringDetailReference) {
        this.recurringDetailReference = recurringDetailReference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public String getPaymentMethodVariant() {
        return paymentMethodVariant;
    }

    public void setPaymentMethodVariant(String paymentMethodVariant) {
        this.paymentMethodVariant = paymentMethodVariant;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public ELV getElv() {
        return elv;
    }

    public void setElv(ELV elv) {
        this.elv = elv;
    }

    public BankAccount getBank() {
        return bank;
    }

    public void setBank(BankAccount bank) {
        this.bank = bank;
    }

    public TokenDetails getTokenDetails() {
        return tokenDetails;
    }

    public void setTokenDetails(TokenDetails tokenDetails) {
        this.tokenDetails = tokenDetails;
    }

    public Name getShopperName() {
        return shopperName;
    }

    public void setShopperName(Name shopperName) {
        this.shopperName = shopperName;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getAliasType() {
        return aliasType;
    }

    public void setAliasType(String aliasType) {
        this.aliasType = aliasType;
    }

    public String getFirstPspReference() {
        return firstPspReference;
    }

    public void setFirstPspReference(String firstPspReference) {
        this.firstPspReference = firstPspReference;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Map<String, String> getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(Map<String, String> additionalData) {
        this.additionalData = additionalData;
    }

    public List<String> getContractTypes() {
        return contractTypes;
    }

    public void setContractTypes(List<String> contractTypes) {
        this.contractTypes = contractTypes;
    }

    public String getAcquirer() {
        return acquirer;
    }

    public void setAcquirer(String acquirer) {
        this.acquirer = acquirer;
    }

    public String getAcquirerAccount() {
        return acquirerAccount;
    }

    public void setAcquirerAccount(String acquirerAccount) {
        this.acquirerAccount = acquirerAccount;
    }

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
