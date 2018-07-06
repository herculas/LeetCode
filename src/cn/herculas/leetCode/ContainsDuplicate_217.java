package cn.herculas.leetCode;

import java.util.Arrays;

public class ContainsDuplicate_217 {
    public boolean containsDuplicate(int[] nums) {
        int size = nums.length;
        Arrays.sort(nums);

        for (int i = 1; i < size; i++) {
            if (nums[i - 1] == nums[i]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] test = {1,1,1,3,3,4,3,2,4,2};
        ContainsDuplicate_217 containsDuplicate_217 = new ContainsDuplicate_217();

        System.out.println(containsDuplicate_217.containsDuplicate(test));
    }
}
