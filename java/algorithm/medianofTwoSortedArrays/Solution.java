package algorithm.medianofTwoSortedArrays;

public class Solution {

    public static void main(String[] args) {
        int[] arr1 = new int[] {1, 3};
        int[] arr2 = new int[] {2};
//        int[] arr1 = new int[] {1, 2};
//        int[] arr2 = new int[] {3, 4};

        System.out.println(new Solution().findMedianSortedArrays(arr1, arr2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergedArrays = new int[nums1.length + nums2.length];

        int i = 0;
        int j = 0;
        int index = 0;

        while (index < mergedArrays.length) {
            if (i < nums1.length && j < nums2.length) {
                mergedArrays[index++] = nums1[i] > nums2[j] ? nums2[j++] : nums1[i++];
            } else if (i < nums1.length) {
                mergedArrays[index++] = nums1[i++];
            } else {
                mergedArrays[index++] = nums2[j++];
            }
        }

        if (mergedArrays.length % 2 == 1) {
            return mergedArrays[mergedArrays.length / 2] / 1.0;
        }
        return (mergedArrays[mergedArrays.length / 2 - 1] + mergedArrays[mergedArrays.length / 2]) / 2.0;
    }
}
