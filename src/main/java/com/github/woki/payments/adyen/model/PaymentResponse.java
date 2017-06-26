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
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Willian Oki &lt;willian.oki@gmail.com&gt;
 */
@SuppressWarnings("serial")
@Getter
@Setter
public class PaymentResponse extends Error implements Serializable {
    private Map<String, String> additionalData = new HashMap<>();
    private FraudResult fraudResult;
    private String pspReference;
    private String refusalReason;
    private ResultCode resultCode;
    private String authCode;
    private Amount dccAmount;
    private String dccSignature;
    private String issuerUrl;
    private String md;
    private String paRequest;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
                .append("additionalData", additionalData)
                .append("authCode", authCode)
                .append("dccAmount", dccAmount)
                .append("dccSignature", dccSignature)
                .append("fraudResult", fraudResult)
                .append("issuerUrl", issuerUrl)
                .append("md", md)
                .append("paRequest", paRequest)
                .append("pspReference", pspReference)
                .append("refusalReason", refusalReason)
                .append("resultCode", resultCode).toString();
    }
}
