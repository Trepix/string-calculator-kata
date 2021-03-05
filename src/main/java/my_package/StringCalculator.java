package my_package;

import java.util.stream.Collectors;
import static my_package.Parser.splitIntoNumbers;

public class StringCalculator {

    public static int add(String input) {
        if (input.isEmpty()) return 0;

        failIfNotValid(input);

        return splitIntoNumbers(input)
                .filter(StringCalculator::isEnoughSmall)
                .sum();
    }

    private static boolean isEnoughSmall(int number) {
        return number <= 1000;
    }

    private static void failIfNotValid(String input) {
        String invalidNumbers = splitIntoNumbers(input)
                .filter(StringCalculator::isNegativeNumber)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(", "));

        if (!invalidNumbers.isEmpty()) throw new IllegalArgumentException("negatives not allowed: " + invalidNumbers);
    }

    private static boolean isNegativeNumber(int number) {
        return number < 0;
    }
}