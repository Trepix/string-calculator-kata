package my_package;

import java.util.stream.Stream;

import static java.util.Arrays.stream;

public class StringCalculator {
    public static int add(String input) {
        if (input.isEmpty()) return 0;

        Stream<String> numbers = splitIntoNumbers(input);
        return numbers.mapToInt(Integer::parseInt).sum();
    }

    private static Stream<String> splitIntoNumbers(String input) {
        return Stream.of(input.split(","))
                .flatMap(x -> stream(x.split("\n")));
    }
}