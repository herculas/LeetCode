package cn.herculas.leetCode.array;

import java.util.Arrays;

public class SingleNumber_136 {
    public int singleNumber(int[] nums) {
        int size = nums.length;

        Arrays.sort(nums);

        if (size == 1) {
            return nums[0];
        }

        if (nums[0] != nums[1]) {
            return nums[0];
        } else if (nums[size - 2] != nums[size - 1]) {
            return nums[size - 1];
        } else {
            for (int i = 1; i < size - 1; i++) {
                if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
                        return nums[i];
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] test = {4, 1, 2, 1, 2};
        SingleNumber_136 singleNumber_136 = new SingleNumber_136();

        System.out.println(singleNumber_136.singleNumber(test));
    }
}
