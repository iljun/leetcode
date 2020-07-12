package algorithm._8;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().myAtoi("   -42"));
    }

    public int myAtoi(String str) {
        str = str.trim();
        char[] charArray = str.toCharArray();
        boolean isNegativeNumber = false;
        StringBuilder stringBuilder = new StringBuilder();

        int i = 0;
        for (char c : charArray) {
            if (c == '-' && i == 0) {
                isNegativeNumber = true;
                i++;
                continue;
            }

            if (c == '+' && i == 0) {
                i++;
                continue;
            }

            i++;

            if (!Character.isDigit(c)) {
                break;
            }
            stringBuilder.append(c);
        }

        if (stringBuilder.length() == 0) {
            stringBuilder.append(0);
        }

        int result = 0;
        try {
            result = Integer.parseInt(stringBuilder.toString());
        } catch (NumberFormatException e) {
            if(stringBuilder.length() < 10) {
                return 0;
            }

            if(isNegativeNumber) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }

        return isNegativeNumber ? result * -1 : result;
    }
}
