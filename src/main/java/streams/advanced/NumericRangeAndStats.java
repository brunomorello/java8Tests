package streams.advanced;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class NumericRangeAndStats {
    private void testMinMaxAvg() {
        IntStream ints = IntStream.rangeClosed(10, 20);
        OptionalInt max = ints.max();
        System.out.println("Max: " + max.getAsInt());

        ints = IntStream.rangeClosed(10, 20);
        OptionalInt min = ints.min();
        System.out.println("Min: " + min.getAsInt());

        ints = IntStream.rangeClosed(10, 20);
        OptionalDouble avg = ints.average();
        System.out.println("Avg: " + avg.getAsDouble());
    }

    public static void main(String[] args) {
        new NumericRangeAndStats().testMinMaxAvg();
    }
}
