package org.example;

public enum Options {
    EVEN ("even"), ODD ("odd"), STAFF ("staff");
    private final String value;
    Options(String value) { this.value = value; }

    public String getValue() {
        return value;
    }
}
