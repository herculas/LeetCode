package cn.herculas.leetCode;

public class RotateArray_189 {
    public void rotate(int[] nums, int k) {

        int size = nums.length;
        for (int i = 0; i < k; i++) {
            int temp = nums[size - 1];
            System.arraycopy(nums, 0, nums, 1, size - 1);
            nums[0] = temp;
        }
    }

    public static void main(String[] args) {
        int[] test = {-1, -100, 3, 99};
        int k = 2;

        RotateArray_189 rotateArray_189 = new RotateArray_189();
        rotateArray_189.rotate(test, k);

        for (int aTest : test) {
            System.out.print(aTest);
        }
    }
}
