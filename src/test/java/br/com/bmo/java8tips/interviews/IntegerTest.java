package br.com.bmo.java8tips.interviews;

import org.junit.jupiter.api.Test;

public class IntegerTest {

    @Test
    void testInt() {
        Integer i = new Integer(4);
        System.out.println(i.byteValue());
        System.out.println("-");
        int i2 = new Integer(4);
//        System.out.println(i2.by);
    }

    @Test
    void testStr() {
        String j = "john";
        String jo = new String(j);

        System.out.println((j == jo) + " " + j.equals(jo));
    }
}
