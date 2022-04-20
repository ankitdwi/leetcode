package leetcode;

import java.util.Arrays;
import java.util.List;

class Solution {
    public static int divide(int dividend, int divisor) {
        // Check for overflow
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) {
            return Integer.MAX_VALUE;
        }
        // Sign of result
        int sign = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0) ? -1 : 1;
        // Quotient
        int quotient = 0;
        // Take the absolute value
        long absoluteDividend = Math.abs((long) dividend);
        long absoluteDivisor = Math.abs((long) divisor);

        while (absoluteDividend >= absoluteDivisor) {
            absoluteDividend -= absoluteDivisor;
            ++quotient;
        }
        //if the sign value computed earlier is -1 then negate the value of quotient
        if (sign == -1) quotient = -quotient;

        return quotient;

    }

    public static void main(String[] args) {
        String jsonString = "[\"ABC\", \"DEF\"]";
        //List<String> ab = new JSONObject(jsonString);
        //System.out.println(ab);
    }
}