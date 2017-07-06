package cn.herculas.leetCode;

import java.util.Arrays;

/**
 * Created by TantaiLan on 2017/7/6.
 */
public class NextPermutation_31 {
    public void nextPermutation(int[] nums) {
        int len = nums.length;

        boolean flag = false;

        for (int i = len - 1; i >= 0; ++i){

            int[] subNums = Arrays.copyOfRange(nums, i, len - 1);
            if (isPermutation(subNums) == true){

            }
        }
    }

    public boolean isPermutation(int[] subNums) {
        return true;
    }


    public static void main(String[] args) {

    }
}
