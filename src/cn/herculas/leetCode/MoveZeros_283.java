package cn.herculas.leetCode;

public class MoveZeros_283 {
    public void moveZeroes(int[] nums) {
        int size = nums.length;

        int index = 0;
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (nums[i] == 0) {
                count ++;
            }
        }

        while (index < size - count) {
            if (nums[index] == 0) {
                for (int i = index + 1; i < size; i++) {
                    nums[i - 1] = nums[i];
                }
                nums[size - 1] = 0;
            } else {
                index++;
            }

        }
    }

    public static void main(String[] args) {
        int[] test = {0, 15, 20, 5, 0, 0, 0, 0, 4, 5, 4, 0, 7, 0, 3, 12};

        MoveZeros_283 moveZeros_283 = new MoveZeros_283();
        moveZeros_283.moveZeroes(test);

        for (int aTest : test) {
            System.out.println(aTest);
        }
    }
}
