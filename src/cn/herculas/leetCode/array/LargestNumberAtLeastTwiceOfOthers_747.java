package cn.herculas.leetCode.array;

public class LargestNumberAtLeastTwiceOfOthers_747 {
    public int dominantIndex(int[] nums) {
        if (nums.length == 1)
            return 0;

        int firstIndex, secondIndex;

        if (nums[0] > nums[1]) {
            firstIndex = 0;
            secondIndex = 1;
        } else {
            firstIndex = 1;
            secondIndex = 0;
        }

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] >= nums[firstIndex]) {
                secondIndex = firstIndex;
                firstIndex = i;
            } else if (nums[i] < nums[firstIndex] && nums[i] >= nums[secondIndex]) {
                secondIndex = i;
            }
        }


        if (nums[firstIndex] >= (nums[secondIndex] * 2))
            return firstIndex;
        else
            return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = {0, 1};

        LargestNumberAtLeastTwiceOfOthers_747 largestNumberAtLeastTwiceOfOthers_747 = new LargestNumberAtLeastTwiceOfOthers_747();
        System.out.println(largestNumberAtLeastTwiceOfOthers_747.dominantIndex(nums1));
    }
}
