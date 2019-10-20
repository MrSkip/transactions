package com.gl.transactioncalculator.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.gl.transactioncalculator.dto.ConversionInputDTO;
import com.gl.transactioncalculator.dto.TransactionDTO;
import com.gl.transactioncalculator.util.JacksonUtils;

import java.util.List;
import java.util.Set;

/**
 * Default data source if none is implemented
 */
public interface DataProvider {

    default List<TransactionDTO> loadTransactions() {
        // TODO replace to streaming mode when memory footprint should be reduced
        final String defaultPath = "/dataset1/transactions.json";
        return JacksonUtils.readValue(getClass().getResourceAsStream(defaultPath), new TypeReference<List<TransactionDTO>>() {
        });
    }

    default Set<ConversionInputDTO> loadConversions() {
        final String defaultPath = "/dataset1/rates.json";
        return JacksonUtils.readValue(getClass().getResourceAsStream(defaultPath), new TypeReference<Set<ConversionInputDTO>>() {
        });
    }

}
