package day05.wrappers;

/*
 * Day 05 - Wrapper classes (Byte, Short, Integer, Long, Float, Double, Character, Boolean)
 * Used to store primitives as objects in collections/generics and for utility methods like parsing.
 */
public class WrapperClassesExample {

    public static void main(String[] args) {
        // Creating wrapper instances using valueOf()
        Integer count = Integer.valueOf(30);
        Double rate = Double.valueOf(149.75);
        Character section = Character.valueOf('B');
        Boolean active = Boolean.valueOf(true);
        System.out.println(count + " | " + rate + " | " + section + " | " + active);

        // Converting wrapper back to primitive
        int rawCount = count.intValue();
        double countAsDouble = count.doubleValue();
        System.out.println("intValue = " + rawCount + ", doubleValue = " + countAsDouble);

        // Parsing Strings into primitives
        int parsedInt = Integer.parseInt("250");
        double parsedDouble = Double.parseDouble("89.5");
        boolean parsedBool = Boolean.parseBoolean("true");
        System.out.println("parsedInt + 10 = " + (parsedInt + 10));
        System.out.println("parsedDouble = " + parsedDouble + ", parsedBool = " + parsedBool);

        // Invalid number string throws NumberFormatException
        try {
            Integer.parseInt("42a");
        } catch (NumberFormatException ex) {
            System.out.println("Invalid number format: " + ex.getMessage());
        }

        // Primitive to String and built-in constants/helpers
        String strValue = Integer.toString(99);
        System.out.println("String value : " + strValue);
        System.out.println("int bounds   : " + Integer.MIN_VALUE + " to " + Integer.MAX_VALUE);
        System.out.println("Binary of 12 : " + Integer.toBinaryString(12));
        System.out.println("isDigit('9') : " + Character.isDigit('9'));
        System.out.println("isLetter('9'): " + Character.isLetter('9'));

        // Comparison methods on wrappers
        Integer x = Integer.valueOf(15);
        System.out.println("x.compareTo(25)         : " + x.compareTo(25));
        System.out.println("x.equals(15)            : " + x.equals(15));
        System.out.println("Integer.compare(40, 25) : " + Integer.compare(40, 25));
    }
}
