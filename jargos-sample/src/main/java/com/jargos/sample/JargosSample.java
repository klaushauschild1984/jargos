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
package com.jargos.sample;

import static com.jargos.Jargos.line;
import static com.jargos.Jargos.lines;
import static com.jargos.Jargos.separator;
import static com.jargos.Jargos.Action.href;

/**
 * @since 1.0
 *
 * @author Klaus Hauschild
 */
public class JargosSample {

    public static void main(final String[] args) {
        lines(//
                        line("Jargos"), //
                        separator(), //
                        line("Google", //
                                        href("http://www.google.de")));
    }

}
