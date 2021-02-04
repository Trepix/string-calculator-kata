package my_package;

import static java.util.Arrays.stream;

public class StringCalculator {
    public static int add(String input) {
        if (input.isEmpty()) return 0;

        String[] numbers = input.split(",");
        return stream(numbers).mapToInt(Integer::parseInt).sum();
    }
}