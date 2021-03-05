package my_package;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.util.stream.Stream.of;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class StringCalculatorTest {

    @Test
    public void should_be_O_when_string_is_empty() {
        int result = StringCalculator.add("");

        assertThat(result, is(0));
    }

    @Test
    public void should_be_the_number_itself_when_input_only_contains_a_number() {
        int result = StringCalculator.add("100");

        assertThat(result, is(100));
    }

    private static Stream<Arguments> numbersAndItsSum() {
        return of(
                arguments("1,2", 3),
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

    @Test
    public void should_be_able_to_use_any_delimiter() {
        int result = StringCalculator.add("//;\n1;2");

        assertThat(result, is(3));
    }

    @Test
    public void should_throw_an_exception_when_input_contain_negative_numbers() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            StringCalculator.add("1,4,-1");
        });

        assertThat(exception.getMessage(), is("negatives not allowed: -1"));
    }

    @Test
    public void should_throw_an_exception_when_input_contain_multiple_negative_numbers() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            StringCalculator.add("1,4,-1,-2");
        });

        assertThat(exception.getMessage(), is("negatives not allowed: -1, -2"));
    }

}
