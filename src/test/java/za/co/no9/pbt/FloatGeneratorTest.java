package za.co.no9.pbt;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FloatGeneratorTest {
    private static final float MIN_FLOAT = -3928.32f;
    private static final float MAX_FLOAT = 1.232f;

    @Test
    public void given_a_fixed_width_list_of_floats_then_the_lists_should_be_of_the_prescribed_length() throws Exception {
        Gen.forAll(FloatGenerator.from(MIN_FLOAT, MAX_FLOAT).list(10, 10), l -> {
            l.stream().forEach(n ->
                    assertTrue(n >= MIN_FLOAT && n <= MAX_FLOAT));
            assertEquals(10, l.size());
        });
    }
}