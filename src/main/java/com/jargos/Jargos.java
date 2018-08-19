package com.jargos;

import java.awt.Color;
import java.util.Arrays;
import java.util.Objects;

public class Jargos {

    private static final String ARGOS_VERSION = "ARGOS_VERSION";
    private static final String ARGOS_TARGET_VERSION = "2";
    private static final String ARGOS_MENU_OPEN = "ARGOS_MENU_OPEN";

    public static void main(final String[] args) {
        lines( //
                        line("Jargos"), //
                        separator(), //
                        line("Hello world"), //
                        line("Hello world", size(12)), //
                        line("Hello world", size(24)) //
        );

    }

    public static boolean isMenuOpen() {
        return Boolean.parseBoolean(System.getenv(ARGOS_MENU_OPEN));
    }

    public static void lines(final Line... lines) {
        if (lines == null || lines.length == 0) {
            return;
        }
        final String argosVersion = System.getenv(ARGOS_VERSION);
        if (!Objects.equals(argosVersion, ARGOS_TARGET_VERSION)) {
            System.out.println(line(String.format("Jargos might be incompatible with Argos %s",
                            argosVersion), color("red")));
        }
        Arrays.stream(lines) //
                        .forEach(System.out::println);
    }

    public static Line line(final String text, final Attribute... attributes) {
        return new Line(text, attributes);
    }

    public static Separator separator() {
        return new Separator();
    }

    /////////////
    // Display //
    /////////////

    public static Attribute color(final String color) {
        return new Attribute("color", color);
    }

    @Deprecated
    public static Attribute color(final Color color) {
        return new Attribute("color", Integer.toHexString(color.getRGB()));
    }

    public static Attribute font(final String fontName) {
        return new Attribute("font", fontName);
    }

    public static Attribute size(final int fontSize) {
        return new Attribute("size", Integer.toString(fontSize));
    }

}
