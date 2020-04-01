package algorithm._20;

import java.util.*;

public class Solution {

    private final static List<String> OPEN_STRING = Arrays.asList("(", "{", "[");
    private final static List<String> CLOSE_STRING = Arrays.asList(")", "}", "]");

    public static void main(String[] args) {
        System.out.println(new Solution().isValid("()[]{}"));
    }

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        String[] splitString = s.split("");
        Stack<String> stack = new Stack<String>();
        for (String string : splitString) {
            if (OPEN_STRING.contains(string)) {
                stack.push(string);
            } else {
                if (stack.empty()) {
                    return false;
                } else {
                    String compareString = stack.pop();
                    int index = OPEN_STRING.indexOf(compareString);
                    if (!string.equals(CLOSE_STRING.get(index))) {
                        return false;
                    }
                }
            }
        }
        return stack.empty();
    }
}
