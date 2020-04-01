package algorithm._10;

public class Solution {

    public static void main(String[] args) {
        String s = "aa";
        String p = "a*";
        System.out.println(new Solution().isMatch(s, p));
    }

    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }

        boolean isMatched = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

        if (p.length() > 1 && p.substring(1, 2).equals("*")) {
            return isMatch(s, p.substring(2)) || (isMatched && isMatch(s.substring(1), p));
        } else {
            return isMatched && isMatch(s.substring(1), p.substring(1));
        }
    }
}
