package algorithm._1;

public class Solution {

    public static void main(String[] args) {
        new Solution().twoSum(new int[]{2, 7, 11, 15}, 9);
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        a : for (int i = 0 ; i < nums.length - 1; i++) {
            result[0] = i;
            for (int j = i + 1 ; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[1] = j;
                    break a;
                }
            }
        }
        return result;
    }
}
