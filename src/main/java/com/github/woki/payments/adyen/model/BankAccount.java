package com.github.woki.payments.adyen.model;

import com.github.woki.payments.adyen.support.ToStringStyle;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

@SuppressWarnings("serial")
public class BankAccount implements Serializable {
    private String bankAccountNumber;
    private String bankCity;
    private String bankLocationId;
    private String bankName;
    private String bic;
    private String countryCode = "US";
    private String iban;
    private String ownerName;
    private String taxId;

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getBankLocationId() {
        return bankLocationId;
    }

    public void setBankLocationId(String bankLocationId) {
        this.bankLocationId = bankLocationId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankCity() {
        return bankCity;
    }

    public void setBankCity(String bankCity) {
        this.bankCity = bankCity;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
                .append("bankAccountNumber", bankAccountNumber)
                .append("bankCity", bankCity)
                .append("bankLocationId", bankLocationId)
                .append("bankName", bankName)
                .append("bic", bic)
                .append("countryCode", countryCode)
                .append("iban", iban)
                .append("ownerName", ownerName)
                .append("taxId", taxId).toString();
    }
}
