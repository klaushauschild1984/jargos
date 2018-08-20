package com.jargos;

import java.util.Arrays;

class Line {

    private final String text;
    private final Attribute[] attributes;

    Line(final String text, Attribute... attributes) {
        this.text = text;
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        final StringBuilder lineBuilder = new StringBuilder();

        lineBuilder.append(text);

        if (attributes != null && attributes.length > 0) {
            lineBuilder.append(" |");
            Arrays.stream(attributes) //
                            .forEach(attribute -> {
                                lineBuilder.append(" ");
                                lineBuilder.append(attribute);
                            });
        }

        return lineBuilder.toString();
    }
}
