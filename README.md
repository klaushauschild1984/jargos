# Jargos

Did you know [Argos](https://github.com/p-e-w/argos)?

This is Java wrapper around it. Write simple script-based extensions for GNOME 3.0 with the power of Java.

## How it works

Argos is designed to build GNOME extension out of the standard output of an executable like a bash script. Jargos helps you the write such scripts by providing a clean API for the possible options. The simplest element is just a line of text. To add custom styling and action performed by clicking the line there are various attributes per line available.

## How to use it

* You need Argos. Install it via \
[<img src="https://img.shields.io/badge/extensions.gnome.org-Argos-9999ff.svg" height="30">](https://extensions.gnome.org/extension/1176/argos/) \
or follow the manual installation instructions.

* Create a maven project using the `jargos-parent` as parent. This handle the proper packaging and script creation for you.

* Write you script like
```java
import static com.jargos.Jargos.line;
import static com.jargos.Jargos.lines;
import static com.jargos.Jargos.separator;
import static com.jargos.Jargos.Action.href;

public class Main {

    public static void main(final String[] args) {
        lines(
            line("Links"),
            separator(),
            line("Google",
                href("http://www.google.com")));
    }

}
```

* Provide via `pom.xml` properties some meta information for the bridge script between Jargos and Argos.
  * `jargos.mainClass` names you main class containing the `main` method
  * `jargos.finalName` names the script

* `mvn package` will do the trick and produces two files in `target/jargos`:
  * `<jargos.finalName>.sh`
  * `.<jargos.finalName>.jar`

* Copy both files over to `~/.config/argos/` and you are done.

## API notes

Jargos will mimic the whole Argos API with some additions. Where it was feasible the attribute arguments will use Java counterparts. A `href` could be passed as `String` or much safer and tighter as `File` or `URL`. An other example are images. Here you provide a `BufferedImage` and Jargos will do the Base64 encoding automatically.

## Compatibility and error handling

Argos provide a meta version of its API via an environment variable `ARGOS_VERSION`. Because Jargos is actually compatible to version _2_ it will display a warning at the buttons caption if the provided version does not match.

Every time an error occurs during script creation Jargos will replace tha desired line by an proper error message within the extensions dropdown.