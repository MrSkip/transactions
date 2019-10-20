package com.gl.transactioncalculator.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gl.transactioncalculator.exception.GeneralRuntimeException;

import java.io.IOException;
import java.io.InputStream;

public class JacksonUtils {
    private static final ObjectMapper OBJECT_MAPPER;

    static {
        OBJECT_MAPPER = new ObjectMapper();
    }

    public static <E> E readValue(final InputStream src, final TypeReference<E> valueTypeRef) {
        try {
            return OBJECT_MAPPER.readValue(src, valueTypeRef);
        } catch (IOException e) {
            throw new GeneralRuntimeException("During json parsing", e);
        }
    }

}
