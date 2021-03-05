package my_package;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringCalculator {

    public static final String DEFAULT_DELIMITERS = "[,|\n]";
    public static final String CUSTOM_DELIMITER_SEQUENCE = "//";

    public static int add(String input) {
        if (input.isEmpty()) return 0;

        failIfNotValid(input);

        return splitIntoNumbers(input).sum();
    }

    private static void failIfNotValid(String input) {
        String invalidNumber = splitIntoNumbers(input)
                .filter(StringCalculator::isInvalidNumber)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(", "));

        if (!invalidNumber.isEmpty()) throw new IllegalArgumentException("negatives not allowed: " + invalidNumber);
    }

    private static boolean isInvalidNumber(int number) {
        return number < 0;
    }

    private static IntStream splitIntoNumbers(String input) {
        return splitByDelimiter(input).mapToInt(Integer::parseInt);
    }

    private static Stream<String> splitByDelimiter(String input) {
        String delimiter = DEFAULT_DELIMITERS;
        String numbers = input;
        if (input.startsWith(CUSTOM_DELIMITER_SEQUENCE)) {
            String[] inputSplitByEndLines = input.split("\n");
            delimiter = inputSplitByEndLines[0].replace(CUSTOM_DELIMITER_SEQUENCE, "");
            numbers = inputSplitByEndLines[1];
        }
        return Stream.of(numbers.split(delimiter));
    }
}