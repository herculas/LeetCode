package cn.herculas.leetCode.search;

import java.util.Arrays;

public class KthLargestElementInAnArray_215 {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);

        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        int[] test1 = {3, 2, 1, 5, 6, 4};
        int[] test2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};

        KthLargestElementInAnArray_215 kthLargestElementInAnArray_215
                = new KthLargestElementInAnArray_215();

        System.out.println(kthLargestElementInAnArray_215.findKthLargest(test2, 4));
    }
}
