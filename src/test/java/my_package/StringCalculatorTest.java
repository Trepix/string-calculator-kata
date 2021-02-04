package my_package;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static java.lang.Integer.parseInt;
import static java.util.stream.Stream.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.in;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class StringCalculatorTest {

    @Test
    public void when_string_is_empty_result_should_be_0() {
        int result = StringCalculator.add("");

        assertThat(result, is(0));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "5", "100", "1232"})
    public void when_string_has_one_numbers_result_should_be_the_number_itself(String number) {
        int result = StringCalculator.add(number);
        int numberAsInteger = parseInt(number);

        assertThat(result, is(numberAsInteger));
    }

    private static Stream<Arguments> numbersAndItsSum() {
        return of(
                arguments("1,2", 3),
                arguments("10,21", 31),
                arguments("0,23", 23)
        );
    }

    @ParameterizedTest
    @MethodSource("numbersAndItsSum")
    public void when_string_two_numbers_result_should_be_the_sum_of_them(String input, int addedNumbers) {
        int result = StringCalculator.add(input);

        assertThat(result, is(addedNumbers));
    }

    @Test
    public void when_string_has_multiple_numbers_result_should_be_the_sum_of_them() {
        int result = StringCalculator.add("1,2,3");

        assertThat(result, is(6));
    }
}
