package za.co.no9.pbt;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IntegerGeneratorTest {
    @Test
    public void given_a_fixed_width_list_of_generator_then_the_lists_should_be_of_the_prescribed_length() throws Exception {
        Gen.forAll(IntegerGenerator.from().list(10, 10), l -> {
            assertEquals(10, l.size());
        });
    }
}