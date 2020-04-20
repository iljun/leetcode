package algorithm._29;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().divide(-2147483648, 2));
    }

    public int divide(int dividend, int divisor) {
        if (divisor == -1 && dividend == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }

        if(divisor == 1) {
            return dividend;
        }

        boolean is = false;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            is = !is;
        }
        long d1 = dividend;
        long d2 = divisor;
        if (d1 < 0) {
            d1 = d1 * -1;
        }

        if (d2 < 0) {
            d2 = d2 * -1;
        }


        if(d1 < d2) {
            return 0;
        }

        int result = 0;
        while (d1 >= d2) {
            d1 -= d2;
            result++;
        }
        if (is) {
            result *= -1;
        }
        return result;
    }
}
