package com.herokuapp.constant;

public enum URLOption {

    LOGIN_PAGE("http://the-internet.herokuapp.com/login"),
    HOVERS_PAGE("http://the-internet.herokuapp.com/hovers"),
    TABLES_PAGE("http://the-internet.herokuapp.com/tables"),
    SECURE_PAGE("http://the-internet.herokuapp.com/secure");

    private final String attribute;

    URLOption(String attribute) {
        this.attribute = attribute;
    }

    public String getAttribute() {
        return attribute;
    }
}
