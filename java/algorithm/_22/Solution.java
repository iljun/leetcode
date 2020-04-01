package algorithm._22;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(3));
    }

    private static final String OPEN_CHARACTER = "(";
    private static final String CLOSE_CHARACTER = ")";

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        this.recursive(1, 0, n, OPEN_CHARACTER, result);
        return result;
    }

    private void recursive(int openCount, int closeCount, int totalCount, String current, List<String> result) {
        if (openCount + closeCount == totalCount * 2) {
            result.add(current);
            return;
        }

        if (openCount < totalCount) {
            this.recursive(openCount + 1, closeCount, totalCount, current + OPEN_CHARACTER, result);
        }

        if (closeCount < openCount){
            this.recursive(openCount, closeCount + 1, totalCount, current + CLOSE_CHARACTER, result);
        }
    }
}
