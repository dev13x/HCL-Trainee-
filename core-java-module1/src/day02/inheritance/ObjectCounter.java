package day02.inheritance;

/*
 * Day 02 - A static variable is shared by every object of the class.
 * The constructor bumps the same counter each time an object is created.
 */
public class ObjectCounter {

    protected static int created = 0;

    public ObjectCounter() {
        created++;
    }
}
