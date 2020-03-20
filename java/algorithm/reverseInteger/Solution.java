package algorithm.reverseInteger;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().reverse(1534236469));
    }

    public int reverse(int x) {
        long result = 0;
        while (x != 0) {
            int a = x % 10;
            x = x / 10;
            result = result * 10 + a;
        }

        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) result;
    }
}
