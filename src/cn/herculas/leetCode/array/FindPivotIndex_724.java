package cn.herculas.leetCode.array;

public class FindPivotIndex_724 {
    public int pivotIndex(int[] nums) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int newSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i != 0)
                newSum += nums[i - 1];
            if (sum - nums[i] == (newSum * 2))
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 7, 3, 6, 5, 6};
        int[] nums2 = {1, 2, 3};
        int[] nums3 = {-1, -1, -1, -1, -1, -1};

        FindPivotIndex_724 findPivotIndex_724 = new FindPivotIndex_724();
//        System.out.println(findPivotIndex_724.pivotIndex(nums1));
//        System.out.println(findPivotIndex_724.pivotIndex(nums2));
        System.out.println(findPivotIndex_724.pivotIndex(nums3));
    }
}
