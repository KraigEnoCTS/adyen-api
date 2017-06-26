package com.github.woki.payments.adyen.model;

import com.github.woki.payments.adyen.support.ToStringStyle;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

@SuppressWarnings("serial")
@Getter
@Setter
public class ThreeDSecureData implements Serializable {
    private String authenticationResponse;
    private String cavv;
    private String cavvAlgorithm;
    private String directoryResponse;
    private String eci;
    private String xid;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
                .append("authenticationResponse", authenticationResponse)
                .append("cavv", cavv)
                .append("cavvAlgorithm", cavvAlgorithm)
                .append("directoryResponse", directoryResponse)
                .append("eci", eci)
                .append("xid", xid).toString();
    }
}
