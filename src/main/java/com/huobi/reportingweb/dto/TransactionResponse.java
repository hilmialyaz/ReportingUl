
package com.huobi.reportingweb.dto;

import java.util.HashMap;
import java.util.Map;

public class TransactionResponse {

    private CustomerInfo customerInfo;
    private Fx fx;
    private Transaction transaction;
    private Merchant__ merchant;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public CustomerInfo getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(CustomerInfo customerInfo) {
        this.customerInfo = customerInfo;
    }

    public TransactionResponse withCustomerInfo(CustomerInfo customerInfo) {
        this.customerInfo = customerInfo;
        return this;
    }

    public Fx getFx() {
        return fx;
    }

    public void setFx(Fx fx) {
        this.fx = fx;
    }

    public TransactionResponse withFx(Fx fx) {
        this.fx = fx;
        return this;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public TransactionResponse withTransaction(Transaction transaction) {
        this.transaction = transaction;
        return this;
    }

    public Merchant__ getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant__ merchant) {
        this.merchant = merchant;
    }

    public TransactionResponse withMerchant(Merchant__ merchant) {
        this.merchant = merchant;
        return this;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public TransactionResponse withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
