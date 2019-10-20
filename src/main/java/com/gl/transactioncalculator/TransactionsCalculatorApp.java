package com.gl.transactioncalculator;

import com.gl.transactioncalculator.service.DataProvider;
import com.gl.transactioncalculator.service.TransactionsServiceImpl;
import com.gl.transactioncalculator.util.ParameterUtils;

public class TransactionsCalculatorApp {

    public static void main(String[] args) {
        new TransactionsServiceImpl(new DataProvider(){})
                .printAll(ParameterUtils.fetchCurrency(args));
    }

}
