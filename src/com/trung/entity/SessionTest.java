package com.trung.entity;

import com.trung.util.Helpers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
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
class SessionTest {
//    Session session;
//
//    @BeforeEach
//    void setUp() {
//        CreditCard creditCard = new CreditCard("cardNumber", "pin", 0, 0L);
//        GregorianCalendar calendar = new GregorianCalendar(2020, Calendar.SEPTEMBER, 16, 8, 46);
//        User user = new User(0, "fullName");
//        Session.SessionBuilder builder = new Session.SessionBuilder();
//        session = builder.setCredit(creditCard).setUser(user).setExpire(calendar.getTime()).build();
//    }
//
//    @Test
//    void getCreditCard() {
//    }
//
//    @Test
//    void getUser() {
//    }
//
//    @Test
//    void getExpire() {
//    }

    @Nested
    class SessionBuilderTest {
        Session.SessionBuilder sessionBuilder;

        @BeforeEach
        void setUp() {
            sessionBuilder = new Session.SessionBuilder();
        }

        @Test
        void testSetCredit() {
            Card card = new Card("cardNumber", "pin", 0, 0L);
            Session.SessionBuilder builder = sessionBuilder.setCredit(card);
            Assertions.assertEquals(builder.build().getCreditCard().getCardNumber(), card.getCardNumber());
        }

        @Test
        void testSetUser() {
            User user = new User(0, "fullName");
            Session.SessionBuilder builder = sessionBuilder.setUser(user);
            Assertions.assertEquals(builder.build().getUser().getId(), user.getId());
        }

        @Test
        void testSetExpire() {
            Date expiredTime = Helpers.addMinutesToDate(new GregorianCalendar(2020, Calendar.AUGUST, 16, 8, 46).getTime(), 30);
            Session.SessionBuilder builder = sessionBuilder.setExpire(expiredTime);
            Assertions.assertEquals(builder.build().getExpire().getTime(), expiredTime.getTime());
            Assertions.assertTrue(builder.build().isExpired());
        }

        @Test
        void testSetExpire2() {
            Session.SessionBuilder builder = sessionBuilder.setExpire(Helpers.addMinutesToDate(new Date(), 30));
            Assertions.assertFalse(builder.build().isExpired());
        }

        @Test
        void testBuild() {
            Session result = sessionBuilder.build();
            Assertions.assertNotNull(result);
        }
    }

}