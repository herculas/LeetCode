package cn.herculas.leetCode.dp;

public class HouseRobber_198 {
    public int rob(int[] nums) {
        int size = nums.length;

        if (size == 0) {
            return 0;
        }

        int[] res = new int[size];

        res[0] = nums[0];

        if (size == 1) {
            return nums[0];
        }

        res[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < size; i++) {
            res[i] = Math.max(res[i - 1], res[i - 2] + nums[i]);
        }

        return res[size - 1];
    }

    public static void main(String[] args) {
        int[] test = {2, 7, 9, 3, 1};

        HouseRobber_198 houseRobber_198 = new HouseRobber_198();
        System.out.println(houseRobber_198.rob(test));
    }
}
