
package com.huobi.reportingweb.dto;

import java.util.HashMap;
import java.util.Map;

public class Transaction {

    private Merchant_ merchant;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Merchant_ getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant_ merchant) {
        this.merchant = merchant;
    }

    public Transaction withMerchant(Merchant_ merchant) {
        this.merchant = merchant;
        return this;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Transaction withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
