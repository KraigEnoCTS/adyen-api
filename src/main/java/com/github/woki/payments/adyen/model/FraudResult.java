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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.woki.payments.adyen.support.ToStringStyle;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author Willian Oki &lt;willian.oki@gmail.com&gt;
 */
@SuppressWarnings("serial")
public class FraudResult implements Serializable {
    private String accountScore;
    private List<Map<String, FraudCheckResult>> results;

    public FraudResult() {
        System.out.println("here");
    }

    public String getAccountScore() {
        return accountScore;
    }

    public void setAccountScore(String accountScore) {
        this.accountScore = accountScore;
    }

    public List<Map<String, FraudCheckResult>> getResults() {
        return results;
    }

    public void setResults(List<Map<String, FraudCheckResult>> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
                .append("accountScore", accountScore)
                .append("results", results).toString();
    }

    public static void main(String[] args) throws Exception {
        String data =
                "{" +
                "\"accountScore\":76," +
                "\"results\":[" +
                    "{\"FraudCheckResult\":{\"accountScore\":8,\"checkId\":2,\"name\":\"CardChunkUsage\"}}," +
                    "{\"FraudCheckResult\":{\"accountScore\":5,\"checkId\":3,\"name\":\"PaymentDetailUsage\"}}," +
                    "{\"FraudCheckResult\":{\"accountScore\":12,\"checkId\":4,\"name\":\"HolderNameUsage\"}}," +
                    "{\"FraudCheckResult\":{\"accountScore\":0,\"checkId\":7,\"name\":\"ShopperIpUsage\"}}," +
                    "{\"FraudCheckResult\":{\"accountScore\":0,\"checkId\":8,\"name\":\"ShopperEmailUsage\"}}," +
                    "{\"FraudCheckResult\":{\"accountScore\":0,\"checkId\":1,\"name\":\"PaymentDetailRefCheck\"}}," +
                    "{\"FraudCheckResult\":{\"accountScore\":0,\"checkId\":6,\"name\":\"ShopperIpRefCheck\"}}," +
                    "{\"FraudCheckResult\":{\"accountScore\":0,\"checkId\":13,\"name\":\"IssuerRefCheck\"}}," +
                    "{\"FraudCheckResult\":{\"accountScore\":0,\"checkId\":15,\"name\":\"IssuingCountryReferral\"}}," +
                    "{\"FraudCheckResult\":{\"accountScore\":0,\"checkId\":26,\"name\":\"ShopperEmailRefCheck\"}}," +
                    "{\"FraudCheckResult\":{\"accountScore\":0,\"checkId\":27,\"name\":\"PmOwnerRefCheck\"}}," +
                    "{\"FraudCheckResult\":{\"accountScore\":0,\"checkId\":10,\"name\":\"HolderNameContainsNumber\"}}," +
                    "{\"FraudCheckResult\":{\"accountScore\":50,\"checkId\":11,\"name\":\"HolderNameIsOneWord\"}}," +
                    "{\"FraudCheckResult\":{\"accountScore\":0,\"checkId\":21,\"name\":\"EmailDomainValidation\"}}," +
                    "{\"FraudCheckResult\":{\"accountScore\":0,\"checkId\":28,\"name\":\"AnonymousProxyCheck\"}}," +
                    "{\"FraudCheckResult\":{\"accountScore\":1,\"checkId\":25,\"name\":\"CVCAuthResultCheck\"}}" +
                "]}";
        ObjectMapper mapper = new ObjectMapper();
        FraudResult fraudResult = mapper.readValue(data, FraudResult.class);
        System.out.println(fraudResult);
    }
}
