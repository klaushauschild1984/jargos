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
package com.jargos.bash;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * Will create the bridge script between Argos and Jargos.
 *
 * @since 1.0
 *
 * @author Klaus Hauschild
 */
public class Script {

    public static void main(final String[] args) throws IOException {
        final File destination = new File(args[0]);
        final String finalName = args[1];

        if (finalName == null) {
            return;
        }

        final File scriptFile = new File(destination, finalName + ".sh");
        try (final Writer writer = new BufferedWriter(new FileWriter(scriptFile))) {
            writer.write("#!/usr/bin/env bash\n");
            writer.write("\n");
            // TODO check if java is present
            // TODO check if jar file is present and accessible
            writer.write(String.format("java -jar ~/.config/argos/.%s.jar\n", finalName));
        }
        scriptFile.setExecutable(true);
    }

}
