package cn.herculas.leetCode.search;

public class FindFirstAndLastPositionOfElementInSortedArray_34 {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        int pointer = -1;
        while (left < right) {

            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                pointer = mid;
                break;
            }
            if (nums[mid] > target) {
                if (right == mid) {
                    break;
                }
                right = mid;

            } else {
                if (left == mid) {
                    break;
                }
                left = mid;
            }
        }

        if (pointer == -1) {
            return new int[]{-1, -1};
        } else {
            int a = pointer;
            int b = pointer;
            while (a > 0 && nums[a - 1] == target) {
                a--;
            }

            while (b < nums.length - 1 && nums[b + 1] == target) {
                b++;
            }

            return new int[]{a, b};
        }

    }

    public static void main(String[] args) {

        int[] test = {5, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 10};

        FindFirstAndLastPositionOfElementInSortedArray_34 findFirstAndLastPositionOfElementInSortedArray_34
                = new FindFirstAndLastPositionOfElementInSortedArray_34();
        findFirstAndLastPositionOfElementInSortedArray_34.searchRange(test, 8);
    }
}
