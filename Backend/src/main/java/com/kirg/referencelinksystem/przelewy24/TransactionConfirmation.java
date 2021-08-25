package com.kirg.referencelinksystem.przelewy24;


import org.springframework.stereotype.Component;

import javax.validation.constraints.Size;

@Component
public class TransactionConfirmation {
    private int merchantId;

    private int posId;

    @Size(max = 100)
    private String sessionId;

    private int amount;

    private int originAmount; // to się różni od TransactionRegistrationReguest

    @Size (max=3)
    private String currency;

    private int orderId;// Numer transakcji przypisany przez P24

    private int methodId; //Metoda płatności, z której skorzystał klient

    private String statement; //Tytuł płatności

    @Size(max=100)
    private String sign;

    public int getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(int merchantId) {
        this.merchantId = merchantId;
    }

    public int getPosId() {
        return posId;
    }

    public void setPosId(int posId) {
        this.posId = posId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getOriginAmount() {
        return originAmount;
    }

    public void setOriginAmount(int originAmount) {
        this.originAmount = originAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getMethodId() {
        return methodId;
    }

    public void setMethodId(int methodId) {
        this.methodId = methodId;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
