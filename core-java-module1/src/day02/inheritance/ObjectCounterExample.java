package day02.inheritance;

/*
 * Day 02 - Counting objects with a static variable (inherited by the subclass)
 */
public class ObjectCounterExample extends ObjectCounter {

    public static void main(String[] args) {
        new ObjectCounter();
        new ObjectCounter();
        new ObjectCounter();

        System.out.println("Objects created so far: " + created);    // 3
    }
}
