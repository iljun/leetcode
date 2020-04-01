package algorithm._11;

public class Solution {

    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(new Solution().maxArea(height));
    }

    public int maxArea(int[] height) {
        int maxArea = 0;

        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int horizontal = j - i;
                int vertical = Math.min(height[i], height[j]);
                maxArea = Math.max(maxArea, horizontal * vertical);
            }
        }

        return maxArea;
    }
}
