package cn.herculas.leetCode.search;

public class FindPeakElement_162 {
    public int findPeakElement(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = (left + right) / 2;

            if(nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            }
            else {
                right = mid;
            }

        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 5, 6, 4};

        FindPeakElement_162 findPeakElement_162 = new FindPeakElement_162();
        System.out.println(findPeakElement_162.findPeakElement(nums));
    }
}
