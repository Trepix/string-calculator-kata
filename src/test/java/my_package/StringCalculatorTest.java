package my_package;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class StringCalculatorTest {

    @Test
    public void when_string_is_empty_result_is_0() {
        int result = StringCalculator.add("");
        assertThat(result, is(0));
    }

    @Test
    public void when_string_has_one_numbers_result_is_the_number_itself() {
        int result = StringCalculator.add("1");
        assertThat(result, is(1));
    }
}
