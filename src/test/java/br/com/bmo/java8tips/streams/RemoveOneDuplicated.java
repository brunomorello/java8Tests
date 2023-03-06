package br.com.bmo.java8tips.streams;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveOneDuplicated {

    int [] listNum = {1,2,3,1,4};

    @Test
    void test() {
        Set<Integer> vals = new HashSet<>(Arrays.asList(1,2,3,1,4));
        System.out.println(vals);
        vals.add(1);
        System.out.println(vals);


    }
}
