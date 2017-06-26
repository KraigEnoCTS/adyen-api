package com.github.woki.payments.adyen.model;

import com.github.woki.payments.adyen.support.ToStringStyle;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
@Getter
@Setter
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
