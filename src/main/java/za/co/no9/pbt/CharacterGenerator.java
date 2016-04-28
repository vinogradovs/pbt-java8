package za.co.no9.pbt;

public class CharacterGenerator extends AbstractGenerator<Character> {
    private final Generator<Integer> generator;

    private CharacterGenerator(char min, char max) {
        generator = IntegerGenerator.from((int) min, (int) max);
    }

    public static CharacterGenerator from() {
        return new CharacterGenerator((char) 0, (char) 255);
    }

    public static CharacterGenerator from(char min, char max) {
        return new CharacterGenerator(min, max);
    }

    @Override
    public Character next() {
        return (char) generator.next().intValue();
    }
}
