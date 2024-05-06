package br.com.bmo.java8tips.collections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExerciseTest {

    @Test
    void testCache() {
        Exercise exercise = new Exercise();
        Cache cache = exercise.useCache();

//        System.out.println(cache.getCache());
        assertEquals(5, cache.getCache().size());
    }

}