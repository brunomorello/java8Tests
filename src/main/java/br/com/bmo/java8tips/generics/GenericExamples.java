package br.com.bmo.java8tips.generics;

public class GenericExamples<T> {

    public <K, V> void printKeyValue(K key, V value) {
        System.out.println("Key=" + key.toString());
        System.out.println("Value=" + value.toString());
    }

    public <T> T showItem(T item) {
        System.out.println(item.toString());
        return item;
    }

    public <T> void showItems(T[] items) {
        for (T item : items) {
            System.out.println(item.toString());
        }
    }

    public <X, Y> boolean checkEquality(X x, Y y) {
        return x.equals(y);
    }
}
