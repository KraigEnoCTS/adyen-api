package com.github.woki.payments.adyen.model;

import com.github.woki.payments.adyen.support.ToStringStyle;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class ForexQuote implements Serializable {
    private Integer basePoints;
    private Date validTill;
    private String account;
    private String accountType;
    private Amount baseAmount;
    private Amount buy;
    private Amount interbank;
    private String reference;
    private Amount sell;
    private String signature;
    private String source;
    private String type;

    public Integer getBasePoints() {
        return basePoints;
    }

    public void setBasePoints(Integer basePoints) {
        this.basePoints = basePoints;
    }

    public Date getValidTill() {
        return validTill;
    }

    public void setValidTill(Date validTill) {
        this.validTill = validTill;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Amount getBaseAmount() {
        return baseAmount;
    }

    public void setBaseAmount(Amount baseAmount) {
        this.baseAmount = baseAmount;
    }

    public Amount getBuy() {
        return buy;
    }

    public void setBuy(Amount buy) {
        this.buy = buy;
    }

    public Amount getInterbank() {
        return interbank;
    }

    public void setInterbank(Amount interbank) {
        this.interbank = interbank;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Amount getSell() {
        return sell;
    }

    public void setSell(Amount sell) {
        this.sell = sell;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
                .append("basePoints", basePoints)
                .append("validTill", validTill)
                .append("account", account)
                .append("accountType", accountType)
                .append("baseAmount", baseAmount)
                .append("buy", buy)
                .append("interbank", interbank)
                .append("reference", reference)
                .append("sell", sell)
                .append("signature", signature)
                .append("source", source)
                .append("type", type).toString();
    }
}
