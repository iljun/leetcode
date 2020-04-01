package algorithm._17;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations("23"));
    }

    static Map<Integer, List<String>> map = new HashMap<>();
    static {
        map.put(2, Arrays.asList("a", "b", "c"));
        map.put(3, Arrays.asList("d", "e", "f"));
        map.put(4, Arrays.asList("g", "h", "i"));
        map.put(5, Arrays.asList("j", "k", "l"));
        map.put(6, Arrays.asList("m", "n", "o"));
        map.put(7, Arrays.asList("p", "q", "r", "s"));
        map.put(8, Arrays.asList("t", "u", "v"));
        map.put(9, Arrays.asList("w", "x", "y", "z"));
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return Collections.EMPTY_LIST;
        }
        String[] split = digits.split("");
        List<String> result = new ArrayList<>();
        for (String s : split) {
            if (result.size() == 0) {
                result.addAll(map.get(Integer.parseInt(s)));
                continue;
            }

            List<String> appendStrings = map.get(Integer.parseInt(s));
            List<String> newResult = new ArrayList<>();
            for (String prefix : result) {
                for (String suffix : appendStrings) {
                    newResult.add(prefix + suffix);
                }
            }
            result = newResult;
        }
        return result;
    }

}
