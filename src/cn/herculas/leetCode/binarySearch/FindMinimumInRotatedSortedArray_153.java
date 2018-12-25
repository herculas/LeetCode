package cn.herculas.leetCode.binarySearch;

public class FindMinimumInRotatedSortedArray_153 {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        if (nums[right] >= nums[left])
            return nums[left];

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[0]) {
                right = mid;
            } else if (nums[mid] >= nums[0]) {
                if (nums[mid] > nums[mid + 1])
                    return nums[mid + 1];
                else
                    left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1};

        FindMinimumInRotatedSortedArray_153 findMinimumInRotatedSortedArray_153 = new FindMinimumInRotatedSortedArray_153();
        System.out.println(findMinimumInRotatedSortedArray_153.findMin(nums));
    }
}
