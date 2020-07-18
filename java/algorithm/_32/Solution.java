package algorithm._32;

import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        String input = ")()())";
        System.out.println(new Solution().longestValidParentheses(input));
    }

    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    result = Math.max(result, i - stack.peek());
                }
            }
        }

        return result;
    }
}
