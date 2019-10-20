package com.gl.transactioncalculator.dto;

import com.gl.transactioncalculator.constant.CurrencyEnum;

import java.math.BigDecimal;
import java.util.Objects;

public class ConversionOutputDTO {
    private BigDecimal value;
    private CurrencyEnum currency;

    public ConversionOutputDTO() {
    }

    public ConversionOutputDTO(BigDecimal value, CurrencyEnum currency) {
        this.value = value;
        this.currency = currency;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public CurrencyEnum getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyEnum currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConversionOutputDTO that = (ConversionOutputDTO) o;
        return Objects.equals(value, that.value) &&
                currency == that.currency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, currency);
    }

    @Override
    public String toString() {
        return "ConversionOutputDTO{" +
                "value=" + value +
                ", currency=" + currency +
                '}';
    }
}
