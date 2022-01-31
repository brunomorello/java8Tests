package functions.primitive;

import model.Employee;

import java.util.function.*;

public class PrimitiveFunctions {
    public static void main(String[] args) {
        Predicate<Integer> evenNumber = x -> x % 2 == 0;
        IntPredicate evenNumberPredicate = x -> x % 2 == 0;
        DoublePredicate doublePredicate = x -> x > 10;
        LongPredicate longPredicate = x -> x > 10;

        //Consumers
        IntConsumer intConsumer;
        DoubleConsumer doubleConsumer;
        LongConsumer longConsumer;

        //Suppliers
        IntSupplier intSupplier;
        DoubleSupplier doubleSupplier;
        LongSupplier longSupplier;

        // Functions
        IntFunction<Employee> employeeIntFunction;
        DoubleFunction<Employee> employeeDoubleFunction;
        LongFunction<Employee> employeeLongFunction;

        // double and int
        Function<Double, Integer> doubleIntegerFunction;
        DoubleFunction<Integer> doubleToIntegerFunction;

        // primitive to primitive
        DoubleToIntFunction doubleToIntFunction;
        LongToIntFunction longToIntFunction;

    }
}
