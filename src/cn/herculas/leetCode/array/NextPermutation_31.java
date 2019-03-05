package cn.herculas.leetCode.array;

import java.util.Arrays;

public class NextPermutation_31 {
    public void nextPermutation(int[] nums) {
        int index = nums.length - 2;

        while (index >= 0 && nums[index + 1] <= nums[index]) {
            index--;
        }

        if (index != -1) {
            int pointer = nums.length - 1;
            while (pointer >= 0 && nums[pointer] <= nums[index]) {
                pointer--;
            }
            swap(nums, pointer, index);
        }
        reverse(nums, index + 1);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int[] nums, int start) {
        int i = start;
        int j = nums.length - 1;

        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        NextPermutation_31 nextPermutation_31 = new NextPermutation_31();
        nextPermutation_31.nextPermutation(nums);

        System.out.println(Arrays.toString(nums));
    }
}
