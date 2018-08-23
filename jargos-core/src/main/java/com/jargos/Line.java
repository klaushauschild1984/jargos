/*
 * Jargos Copyright (C) 2018 Klaus Hauschild
 *
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public
 * License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */
package com.jargos;

/**
 * Represents a line containing text and a number of {@link Attribute attributes}.
 *
 * @since 1.0
 *
 * @author Klaus Hauschild
 */
public class Line {

    private final String text;
    private final Attribute[] attributes;

    Line(final String text, Attribute... attributes) {
        this.text = text;
        // TODO filter for ErrorAttribute
        // TODO filter duplicate attributes, maybe warn
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        final StringBuilder lineBuilder = new StringBuilder();

        lineBuilder.append(text);

        if (attributes != null && attributes.length > 0) {
            lineBuilder.append(" |");
            for (final Attribute attribute : attributes) {
                if (attribute instanceof ErrorAttribute) {
                    return new ErrorLine((ErrorAttribute) attribute).toString();
                }
                lineBuilder.append(" ");
                lineBuilder.append(attribute);
            }
        }

        return lineBuilder.toString();
    }
}
