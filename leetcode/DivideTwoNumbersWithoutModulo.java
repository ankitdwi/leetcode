package leetcode;

public class DivideTwoNumbersWithoutModulo {
    public int divide(int dividend, int divisor) {
        int sign = 1;

        if (dividend > 0 && divisor < 0) {
            sign = -1;
        } else if (dividend < 0 && divisor > 0) {
            sign = -1;
        }

        // Update both divisor and
        // dividend positive
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        // Initialize the quotient
        int quotient = 0;

        while (dividend >= divisor) {
            dividend -= divisor;
            ++quotient;
        }
        //if the sign value computed earlier is -1 then negate the value of quotient
        if (sign == -1) quotient = -quotient;

        return quotient;

    }
}
