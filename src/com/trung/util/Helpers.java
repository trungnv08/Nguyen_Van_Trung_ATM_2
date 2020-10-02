package com.trung.util;


import com.trung.entity.Card;

import java.text.DecimalFormat;
import java.util.Date;

public class Helpers {
    public static boolean isNumericString(String str) {
        return str.chars().allMatch(Character::isDigit);
    }

    public static boolean isCreditCardValid(String cardNumber) {
        return cardNumber.startsWith(Card.startCardNumber) && isNumericString(cardNumber);
    }

    public static String toCurrency(long money, String unit) {
        DecimalFormat formatter = new DecimalFormat("###,###,###.00" + unit);
        return formatter.format(money);
    }
    public static String toCurrency(long money) {

        DecimalFormat formatter = new DecimalFormat("###,###,###.00VND" );
        return formatter.format(money);
    }

    public static String toCellString(String str, int width) {
        if (width <= 0) {
            return "";
        }
        return String.format("%-" + width + "s", String.format("|%" + (str.length() + (width - str.length()) / 2) + "s", str));
    }

    public static String toCellString(long number, int width) {
        return toCellString(String.valueOf(number),width);
    }

    public static Date addMinutesToDate(Date beforeTime, int minutes) {
        final long ONE_MINUTE_IN_MILLIS = 60000;//millisecs
        long curTimeInMs = beforeTime.getTime();
        return new Date(curTimeInMs + (minutes * ONE_MINUTE_IN_MILLIS));
    }
}
