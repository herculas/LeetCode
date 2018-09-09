package cn.herculas.leetCode.backtracking;

import java.util.*;

public class Permutations_46 {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        this.generatePermutations(nums, 0);
        return this.result;
    }

    private void generatePermutations(int[] numbers, int beginPosition) {

        if (beginPosition >= numbers.length) {
            List<Integer> integers = new ArrayList<>();
            for (Integer number: numbers) {
                integers.add(number);
            }
            this.result.add(integers);
        }

        for (int i = beginPosition; i < numbers.length; i++) {
            this.swap(numbers, i, beginPosition);
            this.generatePermutations(numbers, beginPosition + 1);
            this.swap(numbers, i, beginPosition);
        }
    }

    private void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    public static void main(String[] args) {
        int[] test = {1, 2, 3};
        Permutations_46 permutations_46 = new Permutations_46();
        System.out.println(permutations_46.permute(test));
    }
}
