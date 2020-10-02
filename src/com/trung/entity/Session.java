package com.trung.entity;

import java.util.Date;

public class Session {
    private Card creditCard;
    private User user;
    private Date expire;

    private  Session() {

    }


    /**
     * session has time life is 30 minutes (default)
     *
     * @return true if session time life over 30 minutes
     */
    public boolean isExpired() {
//        createInstance();
        return this.expire.before(new Date());
    }


    public Card getCreditCard() {
        return creditCard;
    }

    public User getUser() {
        return user;
    }

    public Date getExpire() {
        return expire;
    }

    public static class SessionBuilder {
        private Session session;

        public SessionBuilder() {
            this.session = new Session();
        }

        public SessionBuilder setCredit(Card credit) {
            this.session.creditCard = credit;
            return this;
        }

        public SessionBuilder setUser(User user) {
            this.session.user = user;
            return this;
        }

        public SessionBuilder setExpire(Date expire) {
            this.session.expire = expire;
            return this;
        }

        public Session build() {
            return this.session;
        }
    }
}
