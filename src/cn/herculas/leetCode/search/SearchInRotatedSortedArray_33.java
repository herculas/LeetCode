package cn.herculas.leetCode.search;

public class SearchInRotatedSortedArray_33 {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;

        int left = 0;
        int right = nums.length - 1;

        while (nums[left] > nums[right] && left != right - 1) {
            int mid = (left + right) / 2;

            if (nums[mid] >= nums[right]) {
                left = mid;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            }
        }

        if (left + 1 != right) return this.BinarySearch(nums, left, right, target);

        if (target >= nums[0] && target <= nums[left]) {
            return this.BinarySearch(nums, 0, left, target);
        } else if (target >= nums[right] && target <= nums[nums.length - 1]) {
            return this.BinarySearch(nums, right, nums.length - 1, target);
        } else {
            return -1;
        }
    }

    private int BinarySearch(int[] nums, int l, int r, int target) {
        int lo = l;
        int hi = r;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (target < nums[mid]) {
                hi = mid - 1;
            } else if (target > nums[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] nums = {4, 5, 6, 7, 1, 2};

        SearchInRotatedSortedArray_33 searchInRotatedSortedArray_33 = new SearchInRotatedSortedArray_33();
        System.out.println(searchInRotatedSortedArray_33.search(nums, 5));
    }
}
