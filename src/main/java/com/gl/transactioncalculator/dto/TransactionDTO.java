package com.gl.transactioncalculator.dto;

import com.gl.transactioncalculator.constant.CurrencyEnum;

import java.math.BigDecimal;

public class TransactionDTO {

    private String sku;
    private BigDecimal amount;
    private CurrencyEnum currency;

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public CurrencyEnum getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyEnum currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "TransactionDTO{" +
                "sku='" + sku + '\'' +
                ", amount=" + amount +
                ", currency=" + currency +
                '}';
    }
}
