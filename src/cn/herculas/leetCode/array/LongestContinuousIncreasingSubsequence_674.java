package cn.herculas.leetCode.array;

public class LongestContinuousIncreasingSubsequence_674 {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return nums.length;

        int maxLength = 1;
        int length = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                length++;
            } else {
                maxLength = Math.max(maxLength, length);
                length = 1;
            }
        }
        return Math.max(maxLength, length);
    }

    public static void main(String[] args) {
        LongestContinuousIncreasingSubsequence_674 longestContinuousIncreasingSubsequence_674 = new LongestContinuousIncreasingSubsequence_674();
        System.out.println(longestContinuousIncreasingSubsequence_674.findLengthOfLCIS(new int[]{2,2,2,2,2}));
    }
}
