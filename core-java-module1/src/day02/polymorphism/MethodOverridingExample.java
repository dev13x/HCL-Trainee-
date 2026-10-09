package day02.polymorphism;

/*
 * Day 02 - Method overriding (runtime polymorphism)
 * The object created decides which version of a method runs, not the reference type.
 */
public class MethodOverridingExample {

    public static void main(String[] args) {
        Bank plain = new Bank();
        System.out.println("Plain bank rate: " + plain.interestRate());

        Bank bank = new SavingsBank();      // parent reference, child object
        System.out.println("Savings bank rate: " + bank.interestRate());    // child's version runs
        bank.describe();
    }
}
