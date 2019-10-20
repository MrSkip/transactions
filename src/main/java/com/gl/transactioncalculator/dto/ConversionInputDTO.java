package com.gl.transactioncalculator.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gl.transactioncalculator.constant.CurrencyEnum;

import java.math.BigDecimal;
import java.util.Objects;

public class ConversionInputDTO {
    @JsonProperty("from")
    private CurrencyEnum from;
    @JsonProperty("to")
    private CurrencyEnum to;
    @JsonProperty("rate")
    private BigDecimal rate;

    public ConversionInputDTO() {
    }

    public CurrencyEnum getFrom() {
        return from;
    }

    public void setFrom(CurrencyEnum from) {
        this.from = from;
    }

    public CurrencyEnum getTo() {
        return to;
    }

    public void setTo(CurrencyEnum to) {
        this.to = to;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Conversion{" +
                "from=" + from +
                ", to=" + to +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConversionInputDTO that = (ConversionInputDTO) o;
        return from == that.from &&
                to == that.to &&
                Objects.equals(rate, that.rate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to, rate);
    }
}
