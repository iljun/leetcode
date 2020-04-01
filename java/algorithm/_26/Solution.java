package algorithm._26;

public class Solution {

    public static void main(String[] args) {
        int[] array = {1,1,2};
        System.out.println(new Solution().removeDuplicates(array));
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
        }

        return i + 1;
    }
}
