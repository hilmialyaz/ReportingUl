package com.huobi.reportingweb.dto;

import java.util.HashMap;
import java.util.Map;

public class GetClientInfoResponse {

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

    public Fx getFx() {
        return fx;
    }

    public void setFx(Fx fx) {
        this.fx = fx;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Merchant__ getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant__ merchant) {
        this.merchant = merchant;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
