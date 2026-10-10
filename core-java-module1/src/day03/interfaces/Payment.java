package day03.interfaces;

/*
 * Day 03 - Interface
 * pay() is abstract: every implementing class must provide the body.
 * currency() is static: it belongs to the interface itself and is called as Payment.currency().
 */
public interface Payment {

    void pay(double amount);

    static String currency() {
        return "INR";
    }
}
