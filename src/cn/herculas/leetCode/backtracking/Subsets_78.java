package cn.herculas.leetCode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets_78 {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        this.generateSubset(nums);
        return this.result;
    }

    private void generateSubset(int[] nums) {
        List<Integer> integers = new ArrayList<>();

        if (nums.length == 0) {
            if (!this.result.contains(integers)) {
                this.result.add(integers);
            }
        } else {
            for (int num: nums) {
                integers.add(num);
            }
            if (!this.result.contains(integers)) {
                this.result.add(integers);
            }
            for (int i = 0; i < nums.length; i++) {
                int[] newNums = new int[nums.length - 1];
                System.arraycopy(nums, 0, newNums, 0, i);
                if (i < nums.length - 1) {
                    System.arraycopy(nums, i + 1, newNums, i, nums.length - i - 1);
                }
                this.generateSubset(newNums);
            }
        }
    }

    public static void main(String[] args) {
        int[] test = {1, 2, 3};
        Subsets_78 subsets_78 = new Subsets_78();
        System.out.println(subsets_78.subsets(test));
    }
}
