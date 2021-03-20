package my_package;


import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Parser {

    static IntStream splitIntoNumbers(String input) {
        Pattern pattern = Pattern.compile("([-\\d]+)");
        Matcher matcher = pattern.matcher(input);
        List<String> numbers = new LinkedList<>();
        while (matcher.find()) {
            numbers.add(matcher.group());
        }
        return numbers.stream().mapToInt(Integer::parseInt);
    }

}
