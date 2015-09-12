package za.co.no9.pbt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;

public class ListOfGenerator<T> extends AbstractGenerator<List<T>> {
    private final Generator<T> generator;
    private Generator<Integer> lengthGenerator = new IntegerGenerator(0, 10);

    public ListOfGenerator(Generator<T> generator) {
        this.generator = generator;
    }

    public void setLengthRange(int minLength, int maxLength) {
        lengthGenerator = new IntegerGenerator(minLength, maxLength);
    }

    @Override
    public List<T> next() {
        return times(lengthGenerator.next(), generator::next);
    }

    @Override
    public String next(final String separator) {
        return join(times(lengthGenerator.next(), () -> generator.next(separator)), separator);
    }

    private static <T> List<T> times(int n, Supplier<T> supplier) {
        List<T> result = new ArrayList<T>();

        for (int lp = 0; lp < n; lp += 1) {
            result.add(supplier.get());
        }

        return result;
    }

    private static String join(Collection collection, String separator) {
        StringBuilder sb = new StringBuilder();
        for (Object o : collection) {
            sb.append(separator).append(o.toString());
        }
        return sb.substring(separator.length());
    }
}
