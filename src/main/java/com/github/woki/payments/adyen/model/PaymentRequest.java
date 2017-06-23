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
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Willian Oki &lt;willian.oki@gmail.com&gt;
 */
@SuppressWarnings("serial")
public class PaymentRequest implements Serializable {
    private Amount additionalAmount;
    private Map<String, String> additionalData = new HashMap<>();
    private Amount amount;
    private BankAccount bankAccount;
    private Address billingAddress;
    private BrowserInfo browserInfo;
    private Integer captureDelayHours;
    private Card card;
    private Date dateOfBirth;
    private ForexQuote dccQuote;
    private Address deliveryAddress;
    private String deliveryDate;
    private String deviceFingerprint;
    private Long fraudOffset;
    private Installments installments;
    private Integer mcc;
    private String md;
    private String merchantAccount;
    private String merchantOrderReference;
    private ThreeDSecureData mpiData;
    private String orderReference;
    private String paResponse;
    private Recurring recurring;
    private String reference;
    private String selectedBrand;
    private String selectedRecurringDetailReference;
    private String sessionId;
    private String shopperEmail;
    private String shopperIP;
    private ShopperInteraction shopperInteraction;
    private String shopperLocale;
    private Name shopperName;
    private String shopperReference;
    private String shopperStatement;
    private String socialSecurityNumber;
    private String telephoneNumber;
    private Map<String, String> metadata = new HashMap<>();

    public String getMerchantAccount() {
        return merchantAccount;
    }

    public void setMerchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getShopperIP() {
        return shopperIP;
    }

    public void setShopperIP(String shopperIP) {
        this.shopperIP = shopperIP;
    }

    public String getShopperEmail() {
        return shopperEmail;
    }

    public void setShopperEmail(String shopperEmail) {
        this.shopperEmail = shopperEmail;
    }

    public String getShopperReference() {
        return shopperReference;
    }

    public void setShopperReference(String shopperReference) {
        this.shopperReference = shopperReference;
    }

    public Long getFraudOffset() {
        return fraudOffset;
    }

    public void setFraudOffset(Long fraudOffset) {
        this.fraudOffset = fraudOffset;
    }

    public Integer getMcc() {
        return mcc;
    }

    public void setMcc(Integer mcc) {
        this.mcc = mcc;
    }

    public String getMerchantOrderReference() {
        return merchantOrderReference;
    }

    public void setMerchantOrderReference(String merchantOrderReference) {
        this.merchantOrderReference = merchantOrderReference;
    }

    public String getSelectedBrand() {
        return selectedBrand;
    }

    public void setSelectedBrand(String selectedBrand) {
        this.selectedBrand = selectedBrand;
    }

    public ShopperInteraction getShopperInteraction() {
        return shopperInteraction;
    }

    public void setShopperInteraction(ShopperInteraction shopperInteraction) {
        this.shopperInteraction = shopperInteraction;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Map<String, String> getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(Map<String, String> additionalData) {
        this.additionalData = additionalData;
    }

    public void addAdditionalDataEntry(String key, String value) {
        if (StringUtils.isNotBlank(key)) {
            additionalData.put(key, value);
        }
    }

    public BrowserInfo getBrowserInfo() {
        return browserInfo;
    }

    public void setBrowserInfo(BrowserInfo browserInfo) {
        this.browserInfo = browserInfo;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address address) {
        this.billingAddress = address;
    }

    public Amount getAdditionalAmount() {
        return additionalAmount;
    }

    public Installments getInstallments() {
        return installments;
    }

    public void setInstallments(Installments installments) {
        this.installments = installments;
    }

    public void setAdditionalAmount(Amount additionalAmount) {
        this.additionalAmount = additionalAmount;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getShopperLocale() {
        return shopperLocale;
    }

    public void setShopperLocale(String shopperLocale) {
        this.shopperLocale = shopperLocale;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public Name getShopperName() {
        return shopperName;
    }

    public void setShopperName(Name shopperName) {
        this.shopperName = shopperName;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getShopperStatement() {
        return shopperStatement;
    }

    public void setShopperStatement(String shopperStatement) {
        this.shopperStatement = shopperStatement;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public Integer getCaptureDelayHours() {
        return captureDelayHours;
    }

    public void setCaptureDelayHours(Integer captureDelayHours) {
        this.captureDelayHours = captureDelayHours;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDeviceFingerprint() {
        return deviceFingerprint;
    }

    public void setDeviceFingerprint(String deviceFingerprint) {
        this.deviceFingerprint = deviceFingerprint;
    }

    public ThreeDSecureData getMpiData() {
        return mpiData;
    }

    public void setMpiData(ThreeDSecureData mpiData) {
        this.mpiData = mpiData;
    }

    public Recurring getRecurring() {
        return recurring;
    }

    public void setRecurring(Recurring recurring) {
        this.recurring = recurring;
    }

    public ForexQuote getDccQuote() {
        return dccQuote;
    }

    public void setDccQuote(ForexQuote dccQuote) {
        this.dccQuote = dccQuote;
    }

    public String getSelectedRecurringDetailReference() {
        return selectedRecurringDetailReference;
    }

    public void setSelectedRecurringDetailReference(String selectedRecurringDetailReference) {
        this.selectedRecurringDetailReference = selectedRecurringDetailReference;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getOrderReference() {
        return orderReference;
    }

    public void setOrderReference(String orderReference) {
        this.orderReference = orderReference;
    }

    public String getMd() {
        return md;
    }

    public void setMd(String md) {
        this.md = md;
    }

    public String getPaResponse() {
        return paResponse;
    }

    public void setPaResponse(String paResponse) {
        this.paResponse = paResponse;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
                .append("additionalAmount", additionalAmount)
                .append("additionalData", additionalData)
                .append("amount", amount)
                .append("bankAccount", bankAccount)
                .append("billingAddress", billingAddress)
                .append("browserInfo", browserInfo)
                .append("captureDelayHours", captureDelayHours)
                .append("card", card)
                .append("dateOfBirth", dateOfBirth)
                .append("dccQuote", dccQuote)
                .append("deliveryAddress", deliveryAddress)
                .append("deliveryDate", deliveryDate)
                .append("deviceFingerprint", deviceFingerprint)
                .append("fraudOffset", fraudOffset)
                .append("installments", installments)
                .append("mcc", mcc).append("md", md)
                .append("merchantAccount", merchantAccount)
                .append("merchantOrderReference", merchantOrderReference)
                .append("mpiData", mpiData)
                .append("orderReference", orderReference)
                .append("paResponse", paResponse)
                .append("recurring", recurring)
                .append("reference", reference)
                .append("selectedBrand", selectedBrand)
                .append("selectedRecurringDetailReference", selectedRecurringDetailReference)
                .append("sessionId", sessionId)
                .append("shopperEmail", shopperEmail)
                .append("shopperIP", shopperIP)
                .append("shopperInteraction", shopperInteraction)
                .append("shopperLocale", shopperLocale)
                .append("shopperName", shopperName)
                .append("shopperReference", shopperReference)
                .append("shopperStatement", shopperStatement)
                .append("socialSecurityNumber", socialSecurityNumber)
                .append("telephoneNumber", telephoneNumber)
                .append("metadata", metadata).toString();
    }
}
