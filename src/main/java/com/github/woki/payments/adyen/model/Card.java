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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author Willian Oki &lt;willian.oki@gmail.com&gt;
 */
@SuppressWarnings("serial")
@Getter
@Setter
public class Card implements Serializable {
    private Integer expiryMonth;
    private Integer expiryYear;
    private String holderName;
    private String number;
    private String cvc;
    private String generationtime;
    private Integer issueNumber;
    private Integer startMonth;
    private Integer startYear;

    private static final SimpleDateFormat GENERATION_TIME_FORMAT;

    static {
        GENERATION_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        GENERATION_TIME_FORMAT.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    public static final String CARD_ENCRYPTED_ADDITIONAL_DATA_KEY_NAME = "card.encrypted.json";

    public void setGenerationtime(Date generationtime) {
        if (generationtime != null) {
            this.generationtime = GENERATION_TIME_FORMAT.format(generationtime);
        }
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
                .append("expiryMonth", expiryMonth)
                .append("expiryYear", expiryYear)
                .append("holderName", holderName)
                .append("cardNumber", number)
                .append("cvc", cvc)
                .append("issueNumber", issueNumber)
                .append("startMonth", startMonth)
                .append("startYear", startYear)
                .toString();
    }
}
