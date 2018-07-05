package cn.herculas.leetCode;

import java.util.Arrays;

public class ArrayPartition_561 {

    public int arrayPairSum(int[] nums) {

        Arrays.sort(nums);

        int size = nums.length;
        int sum = 0;

        for (int i = 0; i < size; i+=2) {
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] test = {1, 4, 2, 3};

        ArrayPartition_561 arrayPartition_561 = new ArrayPartition_561();
        int ap = arrayPartition_561.arrayPairSum(test);
        System.out.println(ap);
    }
}
