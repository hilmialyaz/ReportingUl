
package com.huobi.reportingweb.dto;

import java.util.HashMap;
import java.util.Map;

public class Fx {

    private Merchant merchant;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public Fx withMerchant(Merchant merchant) {
        this.merchant = merchant;
        return this;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Fx withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
