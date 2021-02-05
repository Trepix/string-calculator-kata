package my_package;

import static java.util.Arrays.stream;

public class StringCalculator {
    public static int add(String input) {
        if (input.isEmpty()) return 0;

        String[] numbers = input.split(",");
        return stream(numbers).flatMap(x -> stream(x.split("\n"))).mapToInt(Integer::parseInt).sum();
    }
}