package com.trung.util;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author trung
 * @version 1.0
 * @since 9/15/2020
 */
@DisplayNameGeneration(DisplayNameGenerator.Standard.class)
class LoggerTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void testVerbose() {
        Logger.verbose("message");
        assertEquals("[VERBOSE][]: message\n", outContent.toString());
    }

    @Nested
    class whenDebug {
        boolean debugState = Logger.DEBUG;

        @BeforeEach
        void init() {
            Logger.DEBUG = true;
        }

        @Test
        void testDebugWithDebugFlag() {
            Logger.debug("message");
            assertEquals("[DEBUG][]: message\n", outContent.toString());
        }

        @Test
        void testDebug2WithDebugFlag() {
            Logger.debug(Logger.class, "message");
            assertEquals("[DEBUG][" + Logger.class.getCanonicalName() + "]: message\n", outContent.toString());

        }

        @AfterEach
        void release() {
            Logger.DEBUG = debugState;
        }

    }

    @Nested
    class whenNotDebug {
        boolean debugState = Logger.DEBUG;

        @BeforeEach
        void init() {
            Logger.DEBUG = false;
        }

        @Test
        void testDebugWithVerbose() {
            Logger.debug("message");
            assertEquals("", outContent.toString());
        }

        @Test
        void testDebug2WithVerbose() {
            Logger.debug(Logger.class, "message");
            assertEquals("", outContent.toString());

        }

        @AfterEach
        void release() {
            Logger.DEBUG = debugState;
        }

    }


    @AfterEach
    void restore() {
        System.setOut(originalOut);
    }
}
