package ru.job4j.lambda;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class UsageFunctionTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = UsageFunction.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLinearQuadraticThenQuadraticResults() {
        List<Double> result = UsageFunction.diapason(3, 6, x -> x * x + 1);
        List<Double> expected = Arrays.asList(10D, 17D, 26D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLinearExpThenExpResults() {
        List<Double> result = UsageFunction.diapason(3, 6, x -> Math.pow(5, x));
        List<Double> expected = Arrays.asList(125D, 625D, 3125D);
        assertThat(result, is(expected));
    }

}