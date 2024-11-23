package br.com.bmo.java8tips.interviews;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ATMTest {

    private ATM atm;

    @BeforeEach
    void setUp() {
        atm = new ATM();
    }

    @Test
    void shouldDepositMoney() {
        atm.deposit(new int[]{0,0,1,2,1});
        assertTrue(atm.balance.length == 5);
    }

    @Test
    void shouldWithDraw600() {
        atm.deposit(new int[]{0,0,1,2,1});
        int[] result = atm.withdraw(600);

        // banknote 20
        assertEquals(0, result[0]);

        // banknote 50
        assertEquals(0, result[1]);

        // banknote 100
        assertEquals(1, result[2]);

        // banknote 200
        assertEquals(0, result[3]);

        // banknote 500
        assertEquals(1, result[4]);
    }

    @Test
    void should_not_Withdraw39() {
        atm.deposit(new int[]{100000,100000,100000,100000,100000});
        int[] withdraw = atm.withdraw(39);

        assertEquals(-1, withdraw[0]);
    }

    @Test
    void should_pass_usecase67() {
        atm.deposit(new int[]{250796,638723,691758,845522,938973});
        atm.deposit(new int[]{215317,848628,182949,784609,30472});

        assertEquals(-1, atm.withdraw(701035245)[0]);
        assertEquals(-1, atm.withdraw(109992310)[0]);
        assertEquals(-1, atm.withdraw(755819795)[0]);

        assertTrue(Arrays.equals(new int[]{1,1,0,1188137,969445}, atm.withdraw(722349970)));

        atm.deposit(new int[]{678816,841145,503892,325349,204606});
        atm.deposit(new int[]{604328,586349,680353,733891,136713});
        atm.deposit(new int[]{500950,53467,775875,469508,668335});
        atm.deposit(new int[]{178876,500427,867418,738121,80412});

        assertEquals(-1, atm.withdraw(824714410)[0]);
    }
}