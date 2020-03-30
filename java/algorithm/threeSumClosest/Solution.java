package algorithm.threeSumClosest;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] arr = new int[] { 0,2,1,-3 };
        System.out.println(new Solution().threeSumClosest(arr, 1));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];

         for (int i = 0; i < nums.length; i++) {
             int seconds = i + 1;
             int third = nums.length - 1;

             while (seconds < third) {
                 int sum = nums[i] + nums[seconds] + nums[third];
                 if (sum == target) {
                     return sum;
                 }

                 if (Math.abs(sum - target) < Math.abs(result - target)) {
                     result = sum;
                 }

                 if (sum < target) {
                     seconds++;
                 } else {
                     third--;
                 }
             }
         }
        return result;
    }
}
