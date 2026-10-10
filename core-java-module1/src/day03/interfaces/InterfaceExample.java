package day03.interfaces;

/*
 * Day 03 - Interface: implementing it and calling its static method
 */
public class InterfaceExample {

    public static void main(String[] args) {
        System.out.println("Currency: " + Payment.currency());    // static method, called on the interface

        Payment payment = new UpiPayment();                       // interface reference, class object
        payment.pay(249.50);
    }
}
