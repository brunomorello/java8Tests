package br.com.bmo.java8tips.reflections;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ClassOne {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<String> strClass = String.class;
        Map<String, Integer> mapObj = new HashMap<>();
        Class<?> hasMapClass = mapObj.getClass();
        Class<?> squareClass = Class.forName("br.com.bmo.java8tips.reflections.ClassOne$Square");

//        printClassInfo(strClass, hasMapClass, squareClass);

        var circleObj = new Drawable() {
            @Override
            public int getNumberOfCorners() {
                return 0;
            }
        };

        printClassInfo(Collection.class, boolean.class, int[][].class, Color.class, circleObj.getClass());
    }

    private static void printClassInfo(Class<?> ... classes) {
        for (Class<?> clazz : classes) {
            System.out.println(String.format("class name: %s - package: %s",
                    clazz.getSimpleName(),
                    clazz.getPackageName()));

            System.out.println();

            Class<?>[] clazzInterfaces = clazz.getInterfaces();

            Arrays.stream(clazzInterfaces)
                    .forEach(aClass -> System.out.println(
                            String.format("class %s implementes %s",
                                    clazz.getSimpleName(),
                                    aClass.getSimpleName())
                    ));

            System.out.println();

            System.out.println(String.format("isArray? %b", clazz.isArray()));
            System.out.println(String.format("isPrimitive? %b", clazz.isPrimitive()));
            System.out.println(String.format("isEnum? %b", clazz.isEnum()));
            System.out.println(String.format("isInterface? %b", clazz.isInterface()));
            System.out.println(String.format("isAnonymous? %b", clazz.isAnonymousClass()));
        }
    }

    private static class Square implements Drawable {
        @Override
        public int getNumberOfCorners() {
            return 4;
        }
    }

    private static interface Drawable {
        int getNumberOfCorners();
    }

    private enum Color {
        BLUE, RED, GREEN
    }
}
