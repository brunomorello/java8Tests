package br.com.bmo.java8tips.streams.advanced;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Math.abs;
import static java.lang.Math.max;

abstract class Command {

    abstract String exec(final String text);
//    String exec(final String text) {
//        return text   ;
//    }
}

class TestCommand extends Command {
    @Override
    String exec(String text) {
        return text + "1";
    }
}
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

        Set<Integer> range =IntStream.range(1,10).boxed().collect(Collectors.toSet());
        System.out.println(range);

        int[] str = {2,3,-2};
        Arrays.stream(str).filter(i -> i != 0)
                .reduce((a, b) -> abs(a) < abs(b) ? a : (abs(a) == abs(b) ? max(a, b) : b))
                .getAsInt();

        Command x = new TestCommand();
        System.out.println(x.exec("abc"));

    }

    public static void main(String[] args) {
        new NumericRangeAndStats().testMinMaxAvg();
    }
}
