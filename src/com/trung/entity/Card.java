package com.trung.entity;

import com.trung.util.Helpers;


public class Card {
    public static final String startCardNumber = "0800";
    public static final String DEFAULT_PIN = "000000";

    public enum State {UNKNOWN,ACTIVE, LOCKED}

    private final String cardNumber;
    private String pin;
    private final int userId;
    private State state = State.ACTIVE;
    private long accountBalance;


    public Card(String cardNumber, String pin, int userId, long accountBalance) {
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.userId = userId;
        this.accountBalance = accountBalance;
    }
//region Getter&Setter
    public boolean isLocked() {
        return this.state == State.LOCKED;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public int getUserId() {
        return userId;
    }


    public void setState(State state) {
        this.state = state;
    }


    public String getCardNumber() {
        return cardNumber;
    }

    public long getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(long accountBalance) {
        this.accountBalance = accountBalance;
    }
//endregion
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(Helpers.toCellString(cardNumber, 30));
        sb.append(Helpers.toCellString(pin, 30));
        sb.append(Helpers.toCellString(String.valueOf(userId), 30));
        sb.append(Helpers.toCellString(Helpers.toCurrency(accountBalance), 30));
        sb.append(Helpers.toCellString(state.toString(), 30));
        sb.append("|");
        return sb.toString();
    }

    public static String getHeaders() {
        final StringBuilder sb = new StringBuilder();
        final String[] headers = {"card_number", "PIN", "user_id", "account_balance", "state"};
        for (String header : headers) {
            sb.append(Helpers.toCellString(header, 30));
        }
        sb.append('|');
        return sb.toString();
    }

}
