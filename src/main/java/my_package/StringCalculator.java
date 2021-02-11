package my_package;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

public class StringCalculator {
    public static int add(String input) {
        if (input.isEmpty()) return 0;
        splitIntoNumbers(input).forEach(StringCalculator::validate);
        return splitIntoNumbers(input).sum();
    }

    private static void validate(int number) {
        if (number < 0) throw new IllegalArgumentException("negatives not allowed: " + number);
    }

    private static IntStream splitIntoNumbers(String input) {
        return splitByDelimiter(input).mapToInt(Integer::parseInt);
    }

    private static Stream<String> splitByDelimiter(String input) {
        String delimiter = "[,|\n]";
        if (input.startsWith("//")) {
            delimiter = input.split("\n")[0].replace("//", "");
            String numbers = input.split("\n")[1];
            return Stream.of(numbers.split(delimiter));
        }
        return Stream.of(input.split(delimiter));
    }
}