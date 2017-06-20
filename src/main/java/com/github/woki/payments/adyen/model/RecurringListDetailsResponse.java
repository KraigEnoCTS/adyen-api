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

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Willian Oki &lt;willian.oki@gmail.com&gt;
 */
@SuppressWarnings("serial")
public class RecurringListDetailsResponse extends Error implements Serializable {
    private Date creationDate;
    private String lastKnownShopperEmail;
    private String shopperReference;
    private List<RecurringDetail> details = new ArrayList<>();

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getLastKnownShopperEmail() {
        return lastKnownShopperEmail;
    }

    public void setLastKnownShopperEmail(String lastKnownShopperEmail) {
        this.lastKnownShopperEmail = lastKnownShopperEmail;
    }

    public String getShopperReference() {
        return shopperReference;
    }

    public void setShopperReference(String shopperReference) {
        this.shopperReference = shopperReference;
    }

    public List<RecurringDetail> getDetails() {
        return details;
    }

    public void setDetails(List<RecurringDetail> details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
                .append("creationDate", creationDate)
                .append("lastKnownShopperEmail", lastKnownShopperEmail)
                .append("shopperReference", shopperReference)
                .append("details", details).toString();
    }
}
