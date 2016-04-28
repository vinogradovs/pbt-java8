package za.co.no9.pbt;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LongGeneratorTest {
    @Test
    public void given_a_fixed_width_list_of_generator_then_the_lists_should_be_of_the_prescribed_length() throws Exception {
        Gen.forAll(LongGenerator.from(-10L, 10L).list(10, 10), l -> {
            l.stream().forEach(n ->
                    assertTrue(n >= -10L && n <= 10L));
            assertEquals(10, l.size());
        });
    }
}
