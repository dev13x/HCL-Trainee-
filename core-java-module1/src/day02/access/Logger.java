package day02.access;

/*
 * Day 02 - Access modifiers
 * The constructor is public, so objects can be created from any package.
 * Without "public" it could only be called from inside day02.access.
 */
public class Logger {

    public Logger() {
        System.out.println("Logger ready (public constructor, usable from any package)");
    }
}
