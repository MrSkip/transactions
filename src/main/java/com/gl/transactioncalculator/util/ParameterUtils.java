package com.gl.transactioncalculator.util;

import com.gl.transactioncalculator.constant.CurrencyEnum;
import com.gl.transactioncalculator.exception.ParameterIsMissingException;

public class ParameterUtils {

    private ParameterUtils() {
        throw new IllegalStateException();
    }

    public static CurrencyEnum fetchCurrency(String[] args) {
        if (args == null || args.length == 0) {
            throw new ParameterIsMissingException("Required parameter is missing");
        }
        final String currency = args[0].trim();
        return CurrencyEnum.of(currency);
    }

}
