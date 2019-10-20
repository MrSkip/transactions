package com.gl.transactioncalculator.util;

import com.gl.transactioncalculator.constant.CurrencyEnum;
import com.gl.transactioncalculator.dto.ConversionInputDTO;
import com.gl.transactioncalculator.dto.ConversionOutputDTO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import static com.gl.transactioncalculator.constant.CommonConstants.*;
import static com.gl.transactioncalculator.constant.CommonConstants.DEFAULT_ROUNDING;

public class ConversionUtils {

    private ConversionUtils() {
        throw new IllegalStateException();
    }

    public static ConversionOutputDTO calculate(final Set<ConversionInputDTO> conversionInputDTOS,
                                                final CurrencyEnum from, final CurrencyEnum to,
                                                final BigDecimal amount) {
        if (from.equals(to)) {
            return new ConversionOutputDTO(amount.setScale(EXTERNAL_SCALE, DEFAULT_ROUNDING), from);
        }

        final List<ConversionInputDTO> chainOfConversionInputDTOS
                = deepSearch(conversionInputDTOS, from, to, 0, conversionInputDTOS.size());
        BigDecimal result = null;
        for (int i = chainOfConversionInputDTOS.size(); i-- > 0; ) {
            final ConversionInputDTO conversionInputDTO = chainOfConversionInputDTOS.get(i);
            final BigDecimal rate = conversionInputDTO.getRate();
            if (result == null) {
                result = amount.multiply(rate).setScale(INTERNAL_SCALE, DEFAULT_ROUNDING);
            } else {
                result = result.multiply(rate).setScale(INTERNAL_SCALE, DEFAULT_ROUNDING);
            }
        }

        return result == null
                ? new ConversionOutputDTO(amount.setScale(EXTERNAL_SCALE, DEFAULT_ROUNDING), from)
                : new ConversionOutputDTO(result.setScale(EXTERNAL_SCALE, DEFAULT_ROUNDING), to);
    }

    /**
     * Used to find out the shortest chain of conversions.
     * Average complexity: O(n)
     *
     * @param conversionInputDTOS list of conversions
     * @param from                convert from currency
     * @param to                  convert to currency
     * @param n                   recursive depth index
     * @param size                size of shortest chain of required conversions
     * @return shortest chain of required conversions
     */
    private static List<ConversionInputDTO> deepSearch(final Set<ConversionInputDTO> conversionInputDTOS,
                                                       final CurrencyEnum from, final CurrencyEnum to, int n, int size) {
        final List<ConversionInputDTO> parentSub = new ArrayList<>();
        for (ConversionInputDTO conversionInputDTO : conversionInputDTOS) {
            if (conversionInputDTO.getFrom().equals(from)) {
                if (conversionInputDTO.getTo().equals(to)) {
                    final List<ConversionInputDTO> sub = new ArrayList<>();
                    sub.add(conversionInputDTO);
                    return sub;
                }
                parentSub.add(conversionInputDTO);
            }
        }

        if (parentSub.isEmpty()) {
            return Collections.emptyList();
        }

        final List<ConversionInputDTO> childSub = new ArrayList<>();
        for (ConversionInputDTO parentConversionInputDTO : parentSub) {
            if (size <= n) {
                continue;
            }
            final List<ConversionInputDTO> tmp = deepSearch(
                    conversionInputDTOS, to, parentConversionInputDTO.getTo(), ++n, size);
            if (!tmp.isEmpty()) {
                size = tmp.size();
                tmp.add(parentConversionInputDTO);
                childSub.addAll(tmp);
            }
        }

        return childSub;
    }

}
