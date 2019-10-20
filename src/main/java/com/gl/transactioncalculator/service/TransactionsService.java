package com.gl.transactioncalculator.service;

import com.gl.transactioncalculator.constant.CurrencyEnum;

public interface TransactionsService {

    void printAll(final CurrencyEnum toCurrency);

}
