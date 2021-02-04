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
}
