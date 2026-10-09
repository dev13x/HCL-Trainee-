package day02.polymorphism;

public class SavingsBank extends Bank {

    @Override
    public double interestRate() {
        return 6.5;
    }

    @Override
    public void describe() {
        super.describe();           // run the parent version first
        System.out.println("SavingsBank: higher interest account");
    }
}
