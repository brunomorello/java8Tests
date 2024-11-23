package br.com.bmo.java8tips.interviews;

public class WaysToBuyPensAndPencil {
    public long findWays(int total, int pens, int pencils) {

        // Correct Solution:
        int x = total / pens;
        long attemptsToBuy = 0;
        for (int i=0;i<=x;i++) {
            int affordablePens = i * pens;
            int remainingTotal = total - affordablePens;
            int affordablePencils = ( remainingTotal / pencils+1);
            attemptsToBuy = attemptsToBuy + affordablePencils;
        }
        return attemptsToBuy;


//        int attemptsToBuy = 1;
//
//        if (total < pens && total < pencils) {
//            return attemptsToBuy;
//        }

//        int affordablePens = total % pens == 0 ? 1 : 0;
//
//        int affordablePencils = total % pencils == 0 ?
//                (total / pencils) + affordablePens :
//                pens * affordablePens < total &&  ?
//                        total % pencils;
//
//        attemptsToBuy += (affordablePens + affordablePencils);
//
//        attemptsToBuy += total % pens == 0 ?
//                (total / pens) * ((total % pencils) == 0 ? (total / pencils) : total % pencils) :
//                Math.round(total / pens) * ((total % pens) / pencils);

//    Example 1:
//
//    Input: total = 20, cost1 = 10, cost2 = 5
//    Output: 9
//    Explanation: The price of a pen is 10 and the price of a pencil is 5.
//            - If you buy 0 pens, you can buy 0, 1, 2, 3, or 4 pencils.
//            - If you buy 1 pen, you can buy 0, 1, or 2 pencils.
//            - If you buy 2 pens, you cannot buy any pencils.
//    The total number of ways to buy pens and pencils is 5 + 3 + 1 = 9.

/*kl;

        Input: total = 5, pen = 3, pencil = 2
        Output: 5
            - if you buy 0 pens, you can buy 0, 1, 2
            - if you buy 1 pen, you can buy 0, 1
        Total number of ways to buy pens and pencils is 3 + 2 = 5

*/
//    Example 2:
//
//    Input: total = 5, cost1 = 10, cost2 = 10
//    Output: 1
//    Explanation: The price of both pens and pencils are 10, which cost more than total, so you cannot buy any writing utensils. Therefore, there is only 1 way: buy 0 pens and 0 pencils.

//        return attemptsToBuy;
    }
}
