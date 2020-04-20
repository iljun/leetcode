package algorithm._27;

public class Solution {

    public static void main(String[] args) {
        int[] arr = new int[] {3, 2, 2, 3};
        System.out.println(new Solution().removeElement(arr, 3));
    }

    public int removeElement(int[] nums, int val) {
        int j = 0;
        int i = 0;
        for (; j < nums.length; ) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }

        return i;
    }
}
