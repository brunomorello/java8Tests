package br.com.bmo.java8tips.maps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;

public class MapsExample2 {
    public static void main(String[] args) {
        Map<String, String> test = new HashMap<>();
        test.put("1", "1");
        test.put("2", "1");
        test.put("abc", "1");
        test.put("3", "1");

        Map<String, String> test2 = new HashMap<>();
        test2.put("1", "2");
        test2.put("2", "3");
        test2.put("abc", "2");
        test2.put("3", "3");

        Map<String, String> test3 = new HashMap<>();
        test3.put("1", "4");
        test3.put("2", "5");
        test3.put("abc", "19");
        test3.put("3", "12");

        MapsExample2 mapsExample2 = new MapsExample2();
        System.out.println(mapsExample2.count(test, test2, test3));
    }

    Map<Long, Long> count(Map<String, String>... visits) {

        return Arrays.stream(visits)
                .flatMap(stringStringMap -> stringStringMap.entrySet()
                        .stream()
                        .filter(currEntry -> Pattern.matches("\\d", currEntry.getKey()))
                )
                .collect(HashMap::new,
                        (map, entry) -> {
                            Long currKey = Long.valueOf(entry.getKey());
                            Long currVal = Long.valueOf(entry.getValue());

                            map.put(currKey, Optional.ofNullable(map.get(currKey)).orElse(0l) + currVal);
                        },
                        HashMap::putAll
                );

        // try a reduce / accumulator - OLD IMPL
//        Map<Long, Long> mergedMap2 = new HashMap<>();
//        Arrays.asList(vists)
//                .stream()
//                .flatMap(map -> map.entrySet().stream())
//                .forEach(stringStringEntry -> {
//                    try {
//                        Long currentId = Long.valueOf(stringStringEntry.getKey());
//                        if (mergedMap2.get(currentId) != null) {
//                            mergedMap2.replace(currentId, mergedMap2.get(currentId) + Long.valueOf(stringStringEntry.getValue()));
//                        } else {
//                            mergedMap2.put(currentId, Long.valueOf(stringStringEntry.getValue()));
//                        }
//                    } catch (NumberFormatException ignore) {
//                    }
//                });
//
//        return mergedMap2;
    }
}
