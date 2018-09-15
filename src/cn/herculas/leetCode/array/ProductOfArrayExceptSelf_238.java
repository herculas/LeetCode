package cn.herculas.leetCode.array;

import java.util.Arrays;

public class ProductOfArrayExceptSelf_238 {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                left[i] = 1;
                right[nums.length - 1 - i] = 1;
            } else {
                left[i] = left[i - 1] * nums[i - 1];
                right[nums.length - 1 - i] = right[nums.length - i] * nums[nums.length - i];
            }
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = left[i] * right[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] test = {1, 2, 3, 4};

        ProductOfArrayExceptSelf_238 productOfArrayExceptSelf_238 = new ProductOfArrayExceptSelf_238();
        System.out.println(Arrays.deepToString(new int[][]{productOfArrayExceptSelf_238.productExceptSelf(test)}));
    }
}
