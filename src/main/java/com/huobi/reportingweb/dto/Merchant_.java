
package com.huobi.reportingweb.dto;

import java.util.HashMap;
import java.util.Map;

public class Merchant_ {

    private Integer id;
    private String referenceNo;
    private Integer merchantId;
    private Integer fxTransactionId;
    private Integer acquirerTransactionId;
    private String chainId;
    private Integer agentInfoId;
    private Object returnUrl;
    private String status;
    private String operation;
    private String createdAt;
    private String updatedAt;
    private Object deletedAt;
    private String code;
    private String message;
    private String channel;
    private Object customData;
    private Object parentId;
    private String type;
    private String transactionId;
    private Agent agent;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Merchant_ withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public Merchant_ withReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
        return this;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public Merchant_ withMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
        return this;
    }

    public Integer getFxTransactionId() {
        return fxTransactionId;
    }

    public void setFxTransactionId(Integer fxTransactionId) {
        this.fxTransactionId = fxTransactionId;
    }

    public Merchant_ withFxTransactionId(Integer fxTransactionId) {
        this.fxTransactionId = fxTransactionId;
        return this;
    }

    public Integer getAcquirerTransactionId() {
        return acquirerTransactionId;
    }

    public void setAcquirerTransactionId(Integer acquirerTransactionId) {
        this.acquirerTransactionId = acquirerTransactionId;
    }

    public Merchant_ withAcquirerTransactionId(Integer acquirerTransactionId) {
        this.acquirerTransactionId = acquirerTransactionId;
        return this;
    }

    public String getChainId() {
        return chainId;
    }

    public void setChainId(String chainId) {
        this.chainId = chainId;
    }

    public Merchant_ withChainId(String chainId) {
        this.chainId = chainId;
        return this;
    }

    public Integer getAgentInfoId() {
        return agentInfoId;
    }

    public void setAgentInfoId(Integer agentInfoId) {
        this.agentInfoId = agentInfoId;
    }

    public Merchant_ withAgentInfoId(Integer agentInfoId) {
        this.agentInfoId = agentInfoId;
        return this;
    }

    public Object getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(Object returnUrl) {
        this.returnUrl = returnUrl;
    }

    public Merchant_ withReturnUrl(Object returnUrl) {
        this.returnUrl = returnUrl;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Merchant_ withStatus(String status) {
        this.status = status;
        return this;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Merchant_ withOperation(String operation) {
        this.operation = operation;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Merchant_ withCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Merchant_ withUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public Object getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Object deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Merchant_ withDeletedAt(Object deletedAt) {
        this.deletedAt = deletedAt;
        return this;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Merchant_ withCode(String code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Merchant_ withMessage(String message) {
        this.message = message;
        return this;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public Merchant_ withChannel(String channel) {
        this.channel = channel;
        return this;
    }

    public Object getCustomData() {
        return customData;
    }

    public void setCustomData(Object customData) {
        this.customData = customData;
    }

    public Merchant_ withCustomData(Object customData) {
        this.customData = customData;
        return this;
    }

    public Object getParentId() {
        return parentId;
    }

    public void setParentId(Object parentId) {
        this.parentId = parentId;
    }

    public Merchant_ withParentId(Object parentId) {
        this.parentId = parentId;
        return this;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Merchant_ withType(String type) {
        this.type = type;
        return this;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Merchant_ withTransactionId(String transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public Merchant_ withAgent(Agent agent) {
        this.agent = agent;
        return this;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Merchant_ withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
