package za.co.no9.pbt;

import java.util.concurrent.ThreadLocalRandom;

public class IntegerGenerator extends AbstractGenerator<Integer> {
    private final int min;
    private final int max;

    private IntegerGenerator(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public static Generator<Integer> from() {
        return new IntegerGenerator(Integer.MIN_VALUE, Integer.MAX_VALUE - 1);
    }

    public static Generator<Integer> from(int min, int max) {
        if (max == Integer.MAX_VALUE) {
            throw new IllegalArgumentException("Unable to support max value of Integer.MAX_VALUE");
        }
        return new IntegerGenerator(min, max);
    }

    @Override
    public Integer next() {
        return min < max ? ThreadLocalRandom.current().nextInt(min, max + 1) : min;
    }
}
