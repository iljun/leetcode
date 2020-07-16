package algorithm._18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
//        int[] nums = new int[] {1, 0, -1, 0, -2, 2};
        int[] nums = new int[] {-3,-2,-1,0,0,1,2,3};
        System.out.println(new Solution().fourSum(nums, 0));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List result = new ArrayList();
        if (nums.length < 4) {
            return result;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int k = target - (nums[i] + nums[j]);

                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    int sum = nums[left] + nums[right];
                    if (sum < k) {
                        left++;
                    } else if (sum > k) {
                        right--;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while(left < right && nums[left] == nums[left+1]) {
                            left++;
                        }
                        while(left < right && nums[right] == nums[right-1]) {
                            right--;
                        }
                        while(i < nums.length - 3 && nums[i] == nums[i+1]) {
                            i++;
                        }
                        while(j < nums.length - 2 && nums[j] == nums[j+1]){
                            j++;
                        }

                        left++;
                        right--;
                    }
                }

            }
        }
        return result;
    }

}
