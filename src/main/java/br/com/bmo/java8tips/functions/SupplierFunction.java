package br.com.bmo.java8tips.functions;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierFunction {
    Supplier<String[]> catsSupplier = () -> new String[]{"luna", "izzy", "nicky", "mel"};

    public static void main(String[] args) {
        SupplierFunction supplier = new SupplierFunction();
        List<String> cats = Arrays.asList(supplier.catsSupplier.get());
        cats.forEach(System.out::println);
    }
}
