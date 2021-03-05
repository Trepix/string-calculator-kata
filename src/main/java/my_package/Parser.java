package my_package;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class Parser {

    public static final String DEFAULT_DELIMITERS = "[,|\n]";
    public static final String CUSTOM_DELIMITER_SEQUENCE = "//";
    public static final List<Character> CHARACTERS_TO_ESCAPE_IN_REGEX = asList('.', '^', '$', '*', '+', '?', '(', ')', '[', '{', '\\', '|');

    static IntStream splitIntoNumbers(String input) {
        return splitByDelimiter(input).mapToInt(Integer::parseInt);
    }

    private static Stream<String> splitByDelimiter(String input) {
        String delimiter = DEFAULT_DELIMITERS;
        String numbers = input;
        if (input.startsWith(CUSTOM_DELIMITER_SEQUENCE)) {
            String[] inputSplitByEndLines = input.split("\n");
            delimiter = getDelimiter(inputSplitByEndLines[0]);
            numbers = inputSplitByEndLines[1];
        }
        return Stream.of(numbers.split(delimiter));
    }

    private static String getDelimiter(String inputSplitByEndLine) {
        return inputSplitByEndLine
                .replace(CUSTOM_DELIMITER_SEQUENCE, "")
                .replace("[", "")
                .replace("]", "")
                .chars()
                .mapToObj(i -> (char)i)
                .map(Parser::escapeIfNecessary)
                .collect(Collectors.joining());
    }

    private static String escapeIfNecessary(Character character) {
        if (CHARACTERS_TO_ESCAPE_IN_REGEX.contains(character)) return "\\" + character;
        else return character + "";
    }

}
