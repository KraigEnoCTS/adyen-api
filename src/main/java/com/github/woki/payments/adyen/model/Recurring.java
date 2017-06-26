package com.github.woki.payments.adyen.model;

import com.github.woki.payments.adyen.support.ToStringStyle;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

@SuppressWarnings("serial")
@Getter
@Setter
public class Recurring implements Serializable {
    private ContractType contract;
    private String recurringDetailName;
    private String tokenService;

    public Recurring() {
    }

    public Recurring(ContractType contract, String recurringDetailName, String tokenService) {
        this.contract = contract;
        this.recurringDetailName = recurringDetailName;
        this.tokenService = tokenService;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
                .append("contract", contract)
                .append("recurringDetailName", recurringDetailName)
                .append("tokenService", tokenService).toString();
    }
}
