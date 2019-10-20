package com.gl.transactioncalculator.service;

import com.gl.transactioncalculator.constant.CurrencyEnum;
import com.gl.transactioncalculator.dto.ConversionInputDTO;
import com.gl.transactioncalculator.dto.ConversionOutputDTO;
import com.gl.transactioncalculator.dto.TransactionDTO;
import com.gl.transactioncalculator.util.ConversionUtils;

import java.util.Set;

public class TransactionsServiceImpl implements TransactionsService {
    private final DataProvider dataProvider;

    public TransactionsServiceImpl(DataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }

    @Override
    public void printAll(final CurrencyEnum toCurrency) {
        final Set<ConversionInputDTO> conversions = dataProvider.loadConversions();
        for (TransactionDTO transaction : dataProvider.loadTransactions()) {
            final ConversionOutputDTO output = ConversionUtils.calculate(
                    conversions, transaction.getCurrency(), toCurrency, transaction.getAmount());
            System.out.println(String.format("%s %s %s", transaction.getSku(), output.getValue(), output.getCurrency()));
        }
    }
}
