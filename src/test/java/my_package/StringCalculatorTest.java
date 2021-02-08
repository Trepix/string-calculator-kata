package my_package;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static java.lang.Integer.parseInt;
import static java.util.stream.Stream.of;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class StringCalculatorTest {


    @Test
    public void should_be_O_when_string_is_empty() {
        int result = StringCalculator.add("");

        assertThat(result, is(0));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "5", "100", "1232"})
    public void should_be_the_number_itself_when_input_only_contains_a_number(String number) {
        int result = StringCalculator.add(number);
        int numberAsInteger = parseInt(number);

        assertThat(result, is(numberAsInteger));
    }

    private static Stream<Arguments> numbersAndItsSum() {
        return of(
                arguments("1,2", 3),
                arguments("0,23", 23),
                arguments("1,2,3", 6)
        );
    }


    @ParameterizedTest
    @MethodSource("numbersAndItsSum")
    public void should_add_the_numbers_when_they_are_splatted_by_commas(String input, int addedNumbers) {
        int result = StringCalculator.add(input);

        assertThat(result, is(addedNumbers));
    }

    @Test
    public void should_add_the_numbers_when_they_are_splatted_by_new_lines() {
        int result = StringCalculator.add("1\n2");

        assertThat(result, is(3));
    }

    @Test
    public void should_add_the_numbers_when_they_combine_comas_and_new_lines() {
        int result = StringCalculator.add("1\n2,3");

        assertThat(result, is(6));
    }

}
