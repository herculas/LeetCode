package cn.herculas.leetCode.dp;

public class MaximumSubarray_53 {
    public int maxSubArray(int[] nums) {
        int register = 0;
        int max = Integer.MIN_VALUE;

        int size = nums.length;

        for (int num : nums) {
            if (register < 0) {
                register = 0;
            }

            register += num;
            max = Math.max(max, register);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] test = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        MaximumSubarray_53 maximumSubarray_53 = new MaximumSubarray_53();
        System.out.println(maximumSubarray_53.maxSubArray(test));
    }
}
