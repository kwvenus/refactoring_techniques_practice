package com.tws.refactoring.extract_method;

import com.tws.refactoring.extract_variable.BannerRender;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static com.tws.refactoring.extract_variable.BannerRender.renderBanner;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BannerRenderTest {

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
    public void renderBannerTest(){
        renderBanner("MACOS", "IEXPLORE");
        String expectedResult = "Success";
        assertEquals(expectedResult, outContent.toString());
    }
}
