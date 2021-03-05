package my_package;

import java.util.stream.Collectors;
import static my_package.Parser.splitIntoNumbers;

public class StringCalculator {

    public static int add(String input) {
        if (input.isEmpty()) return 0;

        failIfNotValid(input);

        return splitIntoNumbers(input).filter(x -> x <= 1000).sum();
    }

    private static void failIfNotValid(String input) {
        String invalidNumbers = splitIntoNumbers(input)
                .filter(StringCalculator::isInvalidNumber)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(", "));

        if (!invalidNumbers.isEmpty()) throw new IllegalArgumentException("negatives not allowed: " + invalidNumbers);
    }

    private static boolean isInvalidNumber(int number) {
        return number < 0;
    }
}