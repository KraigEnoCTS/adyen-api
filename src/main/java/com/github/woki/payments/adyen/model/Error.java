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

import java.io.Serializable;

/**
 * @author Willian Oki &lt;willian.oki@gmail.com&gt;
 */
@SuppressWarnings("serial")
public class Error implements Serializable {
    private Integer status;
    private Integer errorCode;
    private String message;
    private String errorType;

    public Error() {
    }

    public Error(Integer status, Integer errorCode, String message, String errorType) {
        this.status = status;
        this.errorCode = errorCode;
        this.message = message;
        this.errorType = errorType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public boolean isOk() { return status == 200; }

    public boolean isBadRequest() { return status == 400; }

    public boolean isUnprocessableEntity() { return status == 422; }

    public boolean isUnauthorized() { return status == 401; }

    public boolean isForbidden() { return status == 403; }

    public boolean isNotFound() { return status == 404; }

    public boolean isInternalServerError() { return status == 500; }
}
