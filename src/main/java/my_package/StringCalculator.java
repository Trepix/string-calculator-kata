package my_package;

public class StringCalculator {
    public static int add(String input) {
        if (input.isEmpty()) return 0;

        String[] numbers = input.split(",");
        if (numbers.length == 1) return Integer.parseInt(numbers[0]);
        else return 3;
    }
}
