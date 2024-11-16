package br.com.bmo.java8tips.maps;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapsExamples {
    public static void main(String[] args) {
        // No sort
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("aaa", 1);
        hashMap.put("bbb", 2);
        hashMap.put("ccc", 3);
        hashMap.put("ddd", 4);
        hashMap.put("eee", 5);
        hashMap.put("fff", 6);
        hashMap.put("ggg", 7);
        hashMap.put("hhh", 8);
        hashMap.put("iii", 9);
        hashMap.put("jjj", 10);
        hashMap.put("kkk", 11);
        hashMap.put("lll", 12);

        for (String key : hashMap.keySet()) {
            System.out.println(String.format("%s - %d", key, hashMap.get(key)));
        }

        Map<String, String> test = new HashMap<>();
        test.put("123", "1");

        hashMap.keySet()
                .stream()
                .map(key -> Long.valueOf(key));

        System.out.println("==================");

        // doubly linked list connecting the inserted items
        // the order is preserved (only advantage of LinkedHashMap)
        // LinkedHashMaps needs more memory than HashMaps
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("aaa", 1);
        linkedHashMap.put("bbb", 2);
        linkedHashMap.put("ccc", 3);
        linkedHashMap.put("ddd", 4);
        linkedHashMap.put("eee", 5);
        linkedHashMap.put("fff", 6);
        linkedHashMap.put("ggg", 7);
        linkedHashMap.put("hhh", 8);
        linkedHashMap.put("iii", 9);
        linkedHashMap.put("jjj", 10);
        linkedHashMap.put("kkk", 11);
        linkedHashMap.put("lll", 12);

        for (String key : linkedHashMap.keySet()) {
            System.out.println(String.format("%s - %d", key, linkedHashMap.get(key)));
        }

        Collections.emptyMap();
    }
}
