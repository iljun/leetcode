package algorithm._35;

public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[] {1,3,5,6};
        System.out.println(new Solution().searchInsert(nums, 0));
    }

    public int searchInsert(int[] nums, int target) {
        for (int i = 0 ; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }
}
