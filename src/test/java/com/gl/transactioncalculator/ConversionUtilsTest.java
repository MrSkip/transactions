package com.gl.transactioncalculator;

import com.fasterxml.jackson.core.type.TypeReference;
import com.gl.transactioncalculator.constant.CurrencyEnum;
import com.gl.transactioncalculator.dto.ConversionInputDTO;
import com.gl.transactioncalculator.dto.ConversionOutputDTO;
import com.gl.transactioncalculator.util.ConversionUtils;
import com.gl.transactioncalculator.util.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public class ConversionUtilsTest {

    @DataProvider(name = "scenarios")
    public static Object[][] dataProvider() {
        final List<TestPresenter> testCases = JacksonUtils.readValue(
                ConversionUtilsTest.class.getResourceAsStream("/scenarios.json"), new TypeReference<List<TestPresenter>>() {
        });
        final Object[][] objects = new Object[testCases.size()][2];
        for (int i = 0; i < testCases.size(); i++) {
            final TestPresenter presenter = testCases.get(i);
            objects[i][0] = presenter.getInput();
            objects[i][1] = presenter.getExpected();
        }
        return objects;
    }

    @Test(dataProvider = "scenarios")
    public void calculateTest(final Input input, final ConversionOutputDTO expected) {
        final ConversionOutputDTO actual
                = ConversionUtils.calculate(input.conversionInputDTOS, input.from, input.to, input.amount);
        Assert.assertEquals(actual, expected);
    }

    public static class TestPresenter {
        private Input input;
        private ConversionOutputDTO expected;

        public Input getInput() {
            return input;
        }

        public void setInput(Input input) {
            this.input = input;
        }

        public ConversionOutputDTO getExpected() {
            return expected;
        }

        public void setExpected(ConversionOutputDTO expected) {
            this.expected = expected;
        }

        @Override
        public String toString() {
            return "TestPresenter{" +
                    "input=" + input +
                    ", expected=" + expected +
                    '}';
        }
    }

    public static class Input {
        private CurrencyEnum from;
        private CurrencyEnum to;
        private BigDecimal amount;
        private Set<ConversionInputDTO> conversionInputDTOS;

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

        public BigDecimal getAmount() {
            return amount;
        }

        public void setAmount(BigDecimal amount) {
            this.amount = amount;
        }

        public Set<ConversionInputDTO> getConversionInputDTOS() {
            return conversionInputDTOS;
        }

        public void setConversionInputDTOS(Set<ConversionInputDTO> conversionInputDTOS) {
            this.conversionInputDTOS = conversionInputDTOS;
        }

        @Override
        public String toString() {
            return "Input{" +
                    "from=" + from +
                    ", to=" + to +
                    ", amount=" + amount +
                    ", conversionInputDTOS=" + conversionInputDTOS +
                    '}';
        }
    }

}
