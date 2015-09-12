package za.co.no9.pbt;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Gen {
    public static int ITERATIONS = 1000;

    public static <T> void forAll(Generator<T> gen1, Consumer<T> consumer) {
        for (int i = 0; i < ITERATIONS; i += 1) {
            consumer.accept(gen1.next());
        }
    }

    public static <T1, T2> void forAll(Generator<T1> gen1, Generator<T2> gen2, BiConsumer<T1, T2> function) {
        for (int i = 0; i < ITERATIONS; i += 1) {
            function.accept(gen1.next(), gen2.next());
        }
    }
}
