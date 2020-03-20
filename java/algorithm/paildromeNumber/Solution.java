package algorithm.paildromeNumber;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(121));
    }

    public boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        }

        if (x < 0 || x % 10 == 0) {
            return false;
        }
        long origin = x;
        List<Integer> arrays = new ArrayList<>();
        while (x != 0) {
            arrays.add(x % 10);
            x = x / 10;
        }

        StringBuilder stringBuilder = new StringBuilder();
        arrays.stream().forEach(array -> stringBuilder.append(array));
        return origin == Long.parseLong(stringBuilder.toString());
    }
}
