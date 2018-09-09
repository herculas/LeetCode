package cn.herculas.leetCode.sort;

import java.util.Arrays;

public class SortColors_75 {
    public void sortColors(int[] nums) {
        int size = nums.length;

        int left = 0;
        int right = size - 1;

        int index = 0;

        while (index < right) {
            if (nums[left] == 0) {
                left++;
                index = left;
                continue;
            }

            if (nums[right] == 2) {
                right--;
                continue;
            }

            if (nums[left] == 2) {
                swap(nums, left, right);
                continue;
            }

            if (nums[left] == 1) {
                if (nums[right] == 0) {
                    swap(nums, left, right);
                    continue;
                } else {
                    index++;
                    if (nums[index] == 0) {
                        swap(nums, index, left);
                    }
                    if (nums[index] == 2) {
                        swap(nums, index, right);
                    }
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] test = {2, 0, 1, 0, 2, 1, 0, 1, 2};

        SortColors_75 sortColors_75 = new SortColors_75();
        sortColors_75.sortColors(test);
        System.out.println(Arrays.deepToString(new int[][]{test}));
    }
}
