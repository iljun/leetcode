package algorithm.romanToInteger;

import java.util.*;

public class Solution {

    // 규칙
    // 모여있는건 전부 더해서 처리
    // 오른쪽 숫자보다 작으면 마이너스 처리이다.

    static Map<String, Integer> map = new HashMap<>();
    static {
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
    }
    public static void main(String[] args) {
        System.out.println(new Solution().romanToInt("III"));
    }

    public int romanToInt(String s) {
        int result = 0;
        String[] split = s.split("");
        int i = split.length - 1;
        while (i > -1) {
            if (i == 0) {
                result += map.get(split[i]);
                break;
            }
            if (split[i].equals(split[i-1])) {
                result += map.get(split[i]) + map.get(split[i]);
                i--;
            } else if (map.get(split[i]) > map.get(split[i-1])) {
                result += map.get(split[i]) - map.get(split[i-1]);
                i--;
            } else {
                result += map.get(split[i]);
            }
            i--;
        }

        return result;
    }
}
