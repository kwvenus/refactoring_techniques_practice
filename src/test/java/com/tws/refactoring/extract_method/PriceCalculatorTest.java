package com.tws.refactoring.extract_method;

import com.tws.refactoring.extract_variable.PriceCalculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PriceCalculatorTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void priceCalculatorTest() {
        PriceCalculator priceCalculator = new PriceCalculator();
        double expectedValue = priceCalculator.getPrice_BasePriceMinusDiscountAddShippingCost(2, 4);
    }
}
