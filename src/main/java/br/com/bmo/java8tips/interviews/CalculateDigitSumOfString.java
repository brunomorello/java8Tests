package br.com.bmo.java8tips.interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class CalculateDigitSumOfString {
    public String digitSum(String s, int k) {
//        Input: s = "11111222223", k = 3
//        Output: "135"
//        Explanation:
//        - For the first round, we divide s into groups of size 3: "111", "112", "222", and "23".
//        Then we calculate the digit sum of each group:
//            1 + 1 + 1 = 3, 1 + 1 + 2 = 4, 2 + 2 + 2 = 6, and 2 + 3 = 5.
//        So, s becomes "3" + "4" + "6" + "5" = "3465" after the first round.
//        - For the second round, we divide s into "346" and "5".
//        Then we calculate the digit sum of each group: 3 + 4 + 6 = 13, 5 = 5.
//        So, s becomes "13" + "5" = "135" after second round.
//        Now, s.length <= k, so we return "135" as the answer.

//        while (s.length() > k) {
//            String auxStr = "";
//            for (int i = 0; i < s.length(); i+=k) {
//                int minValue = i + k;
//                String temp = s.substring(i, Math.min(minValue, s.length()));
//                int sum = 0;
//                for (int j = 0; j < temp.length(); j++) {
//                    sum += Character.getNumericValue(temp.codePointAt(j));
//                }
//                auxStr += "" + sum;
//            }
//            s = auxStr;
//        }

        // best solution (1ms) vs mine (5ms)
        while (s.length() > k) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i += k) {
                int sum = 0;
                for (int j = i; j < Math.min(s.length(), i + k); ++j)
                    sum += s.charAt(j) - '0';
                sb.append(sum);
            }
            s = sb.toString();
        }

        return s;

    }
}
