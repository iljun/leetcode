package algorithm.longestPaildromSubstring;


public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("babad"));
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int left = 0;
        int right = 0;
        for (int i = 0 ; i < s.length(); i++) {
            int oddLength = paildromLength(s, i, i);
            int evenLength = paildromLength(s, i, i + 1);
            int result = Math.max(oddLength, evenLength);
            if (result > right - left) {
                left = i - (result - 1) / 2;
                right = i + result / 2;
            }
        }
        return s.substring(left, right + 1);
    }

    private int paildromLength(String s, int left, int right) {
        while (left > -1 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
