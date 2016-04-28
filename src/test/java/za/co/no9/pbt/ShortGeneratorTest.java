package za.co.no9.pbt;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ShortGeneratorTest {
    @Test
    public void given_a_fixed_width_list_of_shorts_then_the_lists_should_be_of_the_prescribed_length() throws Exception {
        Gen.forAll(ShortGenerator.from((short) -10, (short) 10).list(10, 10), l -> {
            l.stream().forEach(n ->
                    assertTrue(n >= -10 && n <= 10));
            assertEquals(10, l.size());
        });
    }
}