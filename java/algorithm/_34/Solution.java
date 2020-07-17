package algorithm._34;

public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[] {5,7,7,8,8,10};
        System.out.println(new Solution().searchRange(nums, 8));
    }

    // divide and conquer
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[] {-1, -1};

        int leftIndex = searchIndex(nums, target, true);

        if (leftIndex == nums.length || nums[leftIndex] != target) {
            return result;
        }

        result[0] = leftIndex;
        result[1] = searchIndex(nums, target, false) - 1;
        return result;
    }

    private int searchIndex(int[] nums, int target, boolean isLeft) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int middle = (left + right) / 2;
            if (nums[middle] > target || (isLeft && target == nums[middle])) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        return left;
    }
}
