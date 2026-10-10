package day03.interfaces;

public class UpiPayment implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " " + Payment.currency() + " using UPI");
    }
}
