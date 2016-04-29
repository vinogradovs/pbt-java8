package za.co.no9.pbt;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static za.co.no9.pbt.Gen.forAll;

public class MapGeneratorTest {
    @Test
    public void should_create_a_map_from_generators() throws Exception {
        Generator<Long> keyGenerator = LongGenerator.from(1000, 100000);
        Generator<String> stringGenerator = CharacterGenerator.from('A', 'Z').list(30, 50).asString();

        MapGenerator<Long, String> mapGenerator = new MapGenerator<>(keyGenerator, stringGenerator);
        mapGenerator.setIteration(100, 200);

        forAll(mapGenerator, m -> {
            assertTrue(m.size() <= 200);
            m.keySet().forEach(key -> {
                assertTrue(key >= 1000 && key <= 100000);
            });
            m.values().forEach(value -> {
                assertTrue(value.length() >= 30 && value.length() <= 50);
            });
        });
    }
}
