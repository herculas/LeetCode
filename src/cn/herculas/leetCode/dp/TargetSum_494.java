package cn.herculas.leetCode.dp;

public class TargetSum_494 {
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return dfs(nums, S, 0, 0, 0);
    }

    private int dfs(int[] nums, int target, int sum, int index, int count) {
        if (index == nums.length) {
            if (sum == target) {
                count++;
            }
            return count;
        }
        return dfs(nums, target, sum + nums[index], index + 1, count) + dfs(nums, target, sum - nums[index], index + 1, count);
    }
}
