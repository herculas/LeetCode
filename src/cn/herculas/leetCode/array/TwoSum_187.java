package cn.herculas.leetCode.array;

import java.util.Arrays;

public class TwoSum_187 {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;

        while (i < j) {
            if (numbers[i] + numbers[j] > target) {
                j--;
            }
            if (numbers[i] + numbers[j] < target) {
                i++;
            }
            if (numbers[i] + numbers[j] == target) {
                return new int[]{i + 1, j + 1};
            }
        }

        return new int[]{i + 1, j + 1};
    }

    public static void main(String[] args) {
        int[] numbers = {1, 5, 7, 13, 20, 36};
        int target = 18;

        TwoSum_187 twoSum_187 = new TwoSum_187();
        System.out.println(Arrays.deepToString(new int[][]{twoSum_187.twoSum(numbers, target)}));
    }
}
