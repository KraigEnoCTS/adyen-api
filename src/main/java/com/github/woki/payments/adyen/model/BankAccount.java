package com.github.woki.payments.adyen.model;

import com.github.woki.payments.adyen.support.ToStringStyle;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

@SuppressWarnings("serial")
@Getter
@Setter
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
