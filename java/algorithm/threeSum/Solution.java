package algorithm.threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        int[] arr = new int[] {-2,0,1,1,2};
        System.out.println(new Solution().threeSum(arr));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List result = new ArrayList();

        for (int i = 0; i < nums.length; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int secondsIndex = i + 1;
            int thirdIndex = nums.length - 1;

            while (secondsIndex < thirdIndex) {
                int sum = nums[i] + nums[secondsIndex] + nums[thirdIndex];

                if (sum == 0) {
                    List<Integer> zeroArray = Arrays.asList(nums[i], nums[secondsIndex], nums[thirdIndex]);
                    result.add(zeroArray);
                    while (secondsIndex < thirdIndex && nums[secondsIndex] == nums[secondsIndex + 1]) {
                        secondsIndex++;
                    }
                    while (thirdIndex > secondsIndex && nums[thirdIndex] == nums[thirdIndex - 1]) {
                        thirdIndex--;
                    }
                    secondsIndex++;
                    thirdIndex--;
                } else if (sum > 0) {
                    thirdIndex--;
                } else {
                    secondsIndex++;
                }
            }
        }
        return result;
    }

}
