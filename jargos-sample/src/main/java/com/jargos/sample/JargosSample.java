package com.jargos.sample;

import static com.jargos.Jargos.line;
import static com.jargos.Jargos.lines;
import static com.jargos.Jargos.Action.href;

public class JargosSample {

    public static void main(final String[] args) {
        lines(//
                        line("Jargos", //
                                        href("http://www.google.de")));
    }

}
