package algorithm._28;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().strStr("", "a"));
    }

    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }

        if (haystack.isEmpty() || haystack.length() < needle.length()) {
            return -1;
        }

        char[] origin = haystack.toCharArray();
        char[] compare = needle.toCharArray();

        int index = -1;
        for (int i = 0; i < origin.length; i++) {
            int matchedSize = 0;
            for (int j = 0; j < compare.length && i + j < origin.length; j++) {
                if (origin[i + j] == compare[j]) {
                    matchedSize ++;
                }
            }
            if (matchedSize == compare.length) {
                index = i;
                break;
            }
        }

        return index;
    }
}
