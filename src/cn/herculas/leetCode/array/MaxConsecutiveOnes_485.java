package cn.herculas.leetCode.array;

public class MaxConsecutiveOnes_485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums.length == 0)
            return 0;

        int pointer = 0;
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                res = Math.max(res, i - pointer);
                pointer = i + 1;
            }
        }
        return Math.max(res, nums.length - pointer);
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0};
        MaxConsecutiveOnes_485 maxConsecutiveOnes_485 = new MaxConsecutiveOnes_485();
        System.out.println(maxConsecutiveOnes_485.findMaxConsecutiveOnes(nums));
    }
}
