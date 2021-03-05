package my_package;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Parser {

    public static final String DEFAULT_DELIMITERS = "[,|\n]";
    public static final String CUSTOM_DELIMITER_SEQUENCE = "//";

    static IntStream splitIntoNumbers(String input) {
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
