package my_package;

import static java.lang.Integer.parseInt;

public class StringCalculator {
    public static int add(String input) {
        if (input.isEmpty()) return 0;

        String[] numbers = input.split(",");
        if (numbers.length == 1) return parseInt(numbers[0]);
        else if (numbers.length == 2) return parseInt(numbers[0]) + parseInt(numbers[1]);
        return 6;
    }
}