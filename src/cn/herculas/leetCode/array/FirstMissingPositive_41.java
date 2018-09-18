package cn.herculas.leetCode.array;

public class FirstMissingPositive_41 {
    public int firstMissingPositive(int[] nums) {
        int index = 0;

        while (index < nums.length) {
            if (nums[index] > 0
                    && nums[index] < nums.length
                    && nums[index] != nums[nums[index] - 1]
            ) {
                this.swap(index, nums[index] - 1, nums);
            } else {
                index++;
            }
        }

        int i;
        for (i = 1; i <= nums.length; i++) {
            if (nums[i - 1] != i) {
                return i;
            }
        }
        return i;
    }

    private void swap(int indexA, int indexB, int[] array) {
        int temp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = temp;
    }

    public static void main(String[] args) {
        int[] test = {3, 4, -1, 1};
        int[] test2 = {2, 1};
        FirstMissingPositive_41 firstMissingPositive_41 = new FirstMissingPositive_41();
        System.out.println(firstMissingPositive_41.firstMissingPositive(test2));
    }
}
