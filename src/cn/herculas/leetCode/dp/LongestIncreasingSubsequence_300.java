package cn.herculas.leetCode.dp;

public class LongestIncreasingSubsequence_300 {
    public int lengthOfLIS(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = 1;

        int result = 1;

        for (int i = 1; i < nums.length; i++) {

            int max = 0;

            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j] && max < dp[j]) max = dp[j];
            }

            dp[i] = max + 1;
            if (result < dp[i]) result = dp[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        LongestIncreasingSubsequence_300 longestIncreasingSubsequence_300 = new LongestIncreasingSubsequence_300();
        System.out.println(longestIncreasingSubsequence_300.lengthOfLIS(nums));
    }
}
