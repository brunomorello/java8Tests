package br.com.bmo.java8tips.interviews;

public class ATM {

    protected int[] balance;
    private int[] banknotesSeq = new int[] { 20, 50, 100, 200, 500};

    public ATM() {
        balance = new int[] { 0,0,0,0,0 };
    }

    public void deposit(int[] banknotesCount) {
        if (banknotesCount.length == 5) {
            for (int i = 0; i < banknotesCount.length; i++) {
                if (banknotesCount[i] > 0) {
                    balance[i] = balance[i] + banknotesCount[i];
                }
            }
        }
    }

    public int[] withdraw(int amount) {
        boolean error = false;
        int[] tempWithDraw = new int[5];
        int[] responseError = new int[]{-1};
        int result = 0;
        int remainAmount = amount;

        for (int i = 4; i > -1; i--) {
            int currentBanknote = banknotesSeq[i];
            if (remainAmount == 0) {
                break;
            }

            if (remainAmount < currentBanknote) {
                error = true;
            }

            result = calcBalance(remainAmount, currentBanknote);

            if (result >= 1) {
                tempWithDraw[i] = result >= balance[i] ? balance[i] : result;
                remainAmount -= currentBanknote * tempWithDraw[i];
                error = false;
            }
        }

        if (error || remainAmount > 0)
            return responseError;

        for (int i = 0; i < tempWithDraw.length; i++) {
            balance[i]-= tempWithDraw[i];
        }

        return tempWithDraw;
    }

    private int calcBalance(int amount, int banknote) {
        return amount < banknote ? -1 : amount / banknote;
    }
}
