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
package com.github.woki.payments.adyen;

import com.github.woki.payments.adyen.error.APSAccessException;
import com.github.woki.payments.adyen.model.*;
import com.github.woki.payments.adyen.simulator.APS;
import com.github.woki.payments.adyen.support.APUtil;
import com.github.woki.payments.adyen.support.APUtil.ReferenceType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Currency;

import static com.github.woki.payments.adyen.support.APUtil.reference;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

/**
 * @author Willian Oki &lt;willian.oki@gmail.com&gt;
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {APS.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ClientPaymentsTest {
    private static final String PUBKEY_TEXT_ERR1 = "foo";
    private static final String PUBKEY_TEXT_ERR2 = "1|2";

    @LocalServerPort
    private int port;

    private Client client;
    private PaymentRequest req;

    @Before
    public void setUp() {
        client = Client
                .endpoint("http://localhost:" + port)
                .credentials("test_user", "test_password")
                .build();
        req = PaymentRequestBuilder
                .merchantAccount("test_merchant_account")
                .amount(new Amount(Currency.getInstance("USD"), 10))
                .build();
    }

    @Test(expected = APSAccessException.class)
    public void testClientCSEError() {
        Client cli = Client
                .endpoint(APUtil.TEST_ENDPOINT)
                .credentials("merchant", "password")
                .encryptionKey(PUBKEY_TEXT_ERR1)
                .build();
        cli.authorise(PaymentRequestBuilder
                .merchantAccount("mrchntacct")
                .amount(new Amount(Currency.getInstance("EUR"), 1000L))
                .card(CardBuilder
                        .number("4111111111111111")
                        .cvc("737")
                        .expiry(2016, 6)
                        .holder("Johnny Tester Visa")
                        .build())
                .reference(reference(ReferenceType.UUID))
                .shopper(NameBuilder
                        .first("Willian")
                        .last("Oki")
                        .build(), "willian.oki@gmail.com", "127.0.0.1", "Test/DAPI/Authorisation/Willian Oki", ShopperInteraction.Ecommerce)
                .build());
    }

    @Test(expected = APSAccessException.class)
    public void testClientCSEError2() {
        Client cli = Client.endpoint(APUtil.TEST_ENDPOINT).credentials("merchant", "password").encryptionKey(PUBKEY_TEXT_ERR2).build();
        cli.authorise(PaymentRequestBuilder.merchantAccount("mrchntacct").amount(new Amount(Currency.getInstance("EUR"), 1000L))
                .card(CardBuilder.number("4111111111111111").cvc("737").expiry(2016, 6).holder("Johnny Tester Visa").build())
                .reference(reference(ReferenceType.UUID)).shopper(NameBuilder.first("Willian").last("Oki").build(),
                        "willian.oki@gmail.com", "127.0.0.1", "Test/DAPI/Authorisation/Willian Oki", ShopperInteraction.Ecommerce).build());
    }

    @Test
    public void testHttp200handling() throws Exception {
        req.setReference("gimme_200");
        PaymentResponse res = client.authorise(req);
        assertThat(res, notNullValue());
        assertThat(res.isOk(), is(true));
        res = client.authorise3ds(req);
        assertThat(res, notNullValue());
        assertThat(res.isOk(), is(true));
    }

    @Test
    public void testHttp500handling() throws Exception {
        req.setReference("gimme_500");
        PaymentResponse res = client.authorise(req);
        assertThat(res, notNullValue());
        assertThat(res.isInternalServerError(), is(true));
        assertThat(res.getMessage(), is("Unexpected error"));
        res = client.authorise3ds(req);
        assertThat(res, notNullValue());
        assertThat(res.isInternalServerError(), is(true));
        assertThat(res.getMessage(), is("Unexpected error"));
    }

    @Test
    public void testHttp400handling() throws Exception {
        req.setReference("gimme_400");
        PaymentResponse res = client.authorise(req);
        assertThat(res, notNullValue());
        assertThat(res.isBadRequest(), is(true));
        assertThat(res.getMessage(), is("Problem reading or understanding request"));
        res = client.authorise3ds(req);
        assertThat(res, notNullValue());
        assertThat(res.isBadRequest(), is(true));
        assertThat(res.getMessage(), is("Problem reading or understanding request"));
    }

    @Test
    public void testHttp422handling() throws Exception {
        req.setReference("gimme_422");
        PaymentResponse res = client.authorise(req);
        assertThat(res, notNullValue());
        assertThat(res.isUnprocessableEntity(), is(true));
        assertThat(res.getMessage(), is("Request validation error"));
        res = client.authorise3ds(req);
        assertThat(res, notNullValue());
        assertThat(res.isUnprocessableEntity(), is(true));
        assertThat(res.getMessage(), is("Request validation error"));
    }

    @Test
    public void testHttp401handling() throws Exception {
        req.setReference("gimme_401");
        PaymentResponse res = client.authorise(req);
        assertThat(res, notNullValue());
        assertThat(res.isUnauthorized(), is(true));
        assertThat(res.getMessage(), is("Authentication required"));
        res = client.authorise3ds(req);
        assertThat(res, notNullValue());
        assertThat(res.isUnauthorized(), is(true));
        assertThat(res.getMessage(), is("Authentication required"));
    }

    @Test
    public void testHttp403handling() throws Exception {
        req.setReference("gimme_403");
        PaymentResponse res = client.authorise(req);
        assertThat(res, notNullValue());
        assertThat(res.isForbidden(), is(true));
        assertThat(res.getMessage(), is("Insufficient permission to process request"));
        res = client.authorise3ds(req);
        assertThat(res, notNullValue());
        assertThat(res.isForbidden(), is(true));
        assertThat(res.getMessage(), is("Insufficient permission to process request"));
    }

    @Test
    public void testHttp404handling() throws Exception {
        req.setReference("gimme_404");
        PaymentResponse res = client.authorise(req);
        assertThat(res, notNullValue());
        assertThat(res.isNotFound(), is(true));
        assertThat(res.getMessage(), is("Service not found"));
        res = client.authorise3ds(req);
        assertThat(res, notNullValue());
        assertThat(res.isNotFound(), is(true));
        assertThat(res.getMessage(), is("Service not found"));
    }
}
