package com.jargos;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Objects;
import javax.imageio.ImageIO;

public class Jargos {

    private static final String ARGOS_VERSION = "ARGOS_VERSION";
    private static final String ARGOS_TARGET_VERSION = "2";
    private static final String ARGOS_MENU_OPEN = "ARGOS_MENU_OPEN";

    public static void main(final String[] args) {
        lines( //
                        line("Jargos"), //
                        separator(), //
                        line("Hello world"), //
                        line("Hello world", Display.size(12)), //
                        line("Hello world", Display.size(24)) //
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
            Helper.errorMessage(String.format("Jargos might be incompatible with Argos version %s",
                            argosVersion));
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

    public static class Display {

        public static Attribute color(final String color) {
            return Helper.attribute("color", color);
        }

        @Deprecated
        public static Attribute color(final Color color) {
            return Helper.attribute("color", Integer.toHexString(color.getRGB()));
        }

        public static Attribute font(final String fontName) {
            return Helper.attribute("font", fontName);
        }

        public static Attribute size(final int fontSize) {
            return Helper.attribute("size", fontSize);
        }

        public static Attribute iconName(final String iconName) {
            return Helper.attribute("iconName", iconName);
        }

        public static Attribute image(final BufferedImage image) {
            return image("image", image);
        }

        public static Attribute templateImage(final BufferedImage templateImage) {
            return image("templateImage", templateImage);
        }

        private static Attribute image(final String attribute, final BufferedImage image) {
            try {
                final ByteArrayOutputStream imageStream = new ByteArrayOutputStream();
                ImageIO.write(image, "png", imageStream);
                imageStream.close();
                final String encodedImage =
                                Base64.getEncoder().encodeToString(imageStream.toByteArray());
                return Helper.attribute(attribute, encodedImage);
            } catch (final IOException exception) {
                Helper.errorMessage(
                                String.format("Error encoding image: %s", exception.getMessage()));
                throw new RuntimeException(exception);
            }
        }

        public static Attribute imageWidth(final int imageWidth) {
            return Helper.attribute("imageWidth", imageWidth);
        }

        public static Attribute imageHeight(final int imageHeight) {
            return Helper.attribute("imageHeight", imageHeight);
        }

        public static Attribute length(final int length) {
            return Helper.attribute("length", length);
        }

        public static Attribute trim(final boolean trim) {
            return Helper.attribute("trim", trim);
        }

        public static Attribute dropdown(final boolean dropdown) {
            return Helper.attribute("dropdown", dropdown);
        }

        public static Attribute alternate(final boolean alternate) {
            return Helper.attribute("alternate", alternate);
        }

        public static Attribute emojize(final boolean emojize) {
            return Helper.attribute("emojize", emojize);
        }

        public static Attribute ansi(final boolean ansi) {
            return Helper.attribute("ansi", ansi);
        }

        public static Attribute useMarkup(final boolean useMarkup) {
            return Helper.attribute("useMarkup", useMarkup);
        }

        public static Attribute unescape(final boolean unescape) {
            return Helper.attribute("unescape", unescape);
        }

    }

    private static class Helper {

        private static Attribute attribute(final String attribute, final String value) {
            return new Attribute(attribute, value);
        }

        private static Attribute attribute(final String attribute, final int value) {
            return attribute(attribute, Integer.toString(value));
        }

        private static Attribute attribute(final String attribute, final boolean value) {
            return attribute(attribute, Boolean.toString(value));
        }

        private static void errorMessage(final String message) {
            System.out.println(line(message, Display.color("red")));
        }

    }

}
