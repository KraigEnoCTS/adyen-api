package com.github.woki.payments.adyen.model;

import com.github.woki.payments.adyen.support.ToStringStyle;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

@SuppressWarnings("serial")
@Getter
@Setter
public class Name implements Serializable {
    private String firstName;
    private String lastName;
    private GenderType gender = GenderType.U;
    private String infix;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
                .append("firstName", firstName)
                .append("lastName", lastName)
                .append("gender", gender)
                .append("infix", infix).toString();
    }
}
