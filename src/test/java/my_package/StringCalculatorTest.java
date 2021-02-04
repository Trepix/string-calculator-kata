package my_package;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static java.lang.Integer.parseInt;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class StringCalculatorTest {

    @Test
    public void when_string_is_empty_result_is_0() {
        int result = StringCalculator.add("");

        assertThat(result, is(0));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "5", "100", "1232"})
    public void when_string_has_one_numbers_result_is_the_number_itself(String number) {
        int result = StringCalculator.add(number);
        int numberAsInteger = parseInt(number);

        assertThat(result, is(numberAsInteger));
    }

    @Test
    public void when_string_two_numbers_result_is_the_of_them() {
        int result = StringCalculator.add("1,2");

        assertThat(result, is(3));
    }
}
