package za.co.no9.pbt;

import java.util.concurrent.ThreadLocalRandom;

public class FloatGenerator extends AbstractGenerator<Float> {
    private final float min;
    private final float max;

    private FloatGenerator(float min, float max) {
        this.min = min;
        this.max = max;
    }

    public static Generator<Float> from() {
        return new FloatGenerator(Float.MIN_VALUE, Float.MAX_VALUE);
    }

    public static Generator<Float> from(float min, float max) {
        return new FloatGenerator(min, max);
    }

    @Override
    public Float next() {
        return min < max ? ((float) ThreadLocalRandom.current().nextDouble(min, max)) : min;
    }
}
