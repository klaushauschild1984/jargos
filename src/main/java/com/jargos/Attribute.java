package com.jargos;

class Attribute {

    private final String key;
    private final String value;

    public Attribute(final String key, final String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%s=%s", key, value);
    }

}
