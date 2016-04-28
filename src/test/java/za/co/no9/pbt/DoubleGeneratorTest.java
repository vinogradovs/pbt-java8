package za.co.no9.pbt;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DoubleGeneratorTest {
    private static final double MIN_DOUBLE = -3928.32;
    private static final double MAX_DOUBLE = 1.232;

    @Test
    public void given_a_fixed_width_list_of_doubles_then_the_lists_should_be_of_the_prescribed_length() throws Exception {
        Gen.forAll(DoubleGenerator.from(MIN_DOUBLE, MAX_DOUBLE).list(10, 10), l -> {
            l.stream().forEach(n ->
                    assertTrue(n >= MIN_DOUBLE && n <= MAX_DOUBLE));
            assertEquals(10, l.size());
        });
    }
}