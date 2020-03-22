package algorithm.zigzag_conversion;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().convert("PAYPALISHIRING", 1));
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> result = new ArrayList<>();

        for (int i = 0 ; i < numRows ; i++) {
            result.add(new StringBuilder());
        }

        String[] splitString = s.split("");
        int row = 0;
        boolean down = false;
        for (int i = 0 ; i < splitString.length; i++) {
            result.get(row).append(splitString[i]);
            if (row == 0 || row == numRows - 1) {
                down = !down;
            }

            row = down ? row + 1 : row - 1;
        }

        StringBuilder appendRows = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            appendRows.append(result.get(i).toString());
        }
        return appendRows.toString();
    }
}