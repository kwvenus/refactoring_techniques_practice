package com.tws.refactoring.extract_method;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OwingPrinterTest {
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
    public void printOwing() {
        System.out.print("hello");
        assertEquals("hello", outContent.toString());
    }

    @Test
    public void testPrintOwing(){
        OwingPrinter owingPrinter = new OwingPrinter();
        Order order = new Order(1.1);
        List<Order> orderList = new ArrayList<>();
        orderList.add(order);

        owingPrinter.printOwing("Testing", orderList);
        String expectedResult = "*****************************\r\n" +
                "****** Customer totals ******\r\n" +
                "*****************************\r\n" +
                "name: Testing\r\n" +
                "amount: 1.1\r\n";
        assertEquals(expectedResult, outContent.toString());
    }
}