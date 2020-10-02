package com.trung.util;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author trung
 * @version 1.0
 * @since 9/15/2020
 */
class HelpersTest {
    @BeforeAll
    @Ignore
    static void setUp() {

    }

    @Test
    void testIsNumericString() {
        boolean result = Helpers.isNumericString("str");
        assertFalse(result);
        boolean result1 = Helpers.isNumericString("0123456789");
        assertTrue(result1);
    }

    @Test
    void testIsCreditCardValid() {
        boolean result = Helpers.isCreditCardValid("cardNumber");
        assertFalse(result);
        assertFalse(Helpers.isCreditCardValid("0800String"));
        boolean result1 = Helpers.isCreditCardValid("080012345678");
        assertTrue(result1);
    }

    @Test
    void testToCurrency() {
        String result = Helpers.toCurrency(100L, "VND");
        assertEquals("100.00VND", result);
        result = Helpers.toCurrency(100L, "USD");
        assertEquals("100.00USD", result);
    }

    @Test
    void testToCurrencyDefault() {
        String result1 = Helpers.toCurrency(100L);
        assertEquals("100.00VND", result1);
    }

    @Test
    void testToCellString() {
        String result = Helpers.toCellString("str", 10);
        assertEquals("|   str   ", result);
        String result1 = Helpers.toCellString("str", 0);
        assertEquals("", result1);
    }

    @Test
    void testToCellString2() {
        String result = Helpers.toCellString(0L, 10);
        assertEquals("|    0    ", result);
        String result1 = Helpers.toCellString(0L, 0);
        assertEquals("", result1);
    }

    @Test
    void testAddMinutesToDate() {
        Date result = Helpers.addMinutesToDate(new GregorianCalendar(2020, Calendar.SEPTEMBER, 15, 16, 19).getTime(), 0);
        assertEquals(new GregorianCalendar(2020, Calendar.SEPTEMBER, 15, 16, 19).getTime(), result);
        Date result1 = Helpers.addMinutesToDate(new GregorianCalendar(2020, Calendar.SEPTEMBER, 15, 16, 19).getTime(), 30);
        assertEquals(new GregorianCalendar(2020, Calendar.SEPTEMBER, 15, 16, 49).getTime(), result1);
    }
}