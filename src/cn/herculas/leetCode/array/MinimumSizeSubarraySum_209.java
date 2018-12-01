package cn.herculas.leetCode.array;

public class MinimumSizeSubarraySum_209 {
    public int minSubArrayLen(int s, int[] nums) {

        if (nums.length == 0)
            return 0;

        int pointer1 = 0;
        int pointer2 = 0;
        int sum = 0;
        int minLen = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum >= s) {
                pointer2 = i;
                minLen = pointer2 - pointer1 + 1;
                break;
            }
        }


        while (pointer1 != nums.length - 1 || pointer2 != nums.length - 1) {
            if (sum >= s) {
                minLen = Math.min(minLen, pointer2 - pointer1 + 1);
                sum -= nums[pointer1];
                pointer1++;
            } else {
                if (pointer2 < nums.length - 1) {
                    pointer2++;
                    sum += nums[pointer2];
                } else {
                    break;
                }
            }
        }
        return minLen;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int s = 11;

        MinimumSizeSubarraySum_209 minimumSizeSubarraySum_209 = new MinimumSizeSubarraySum_209();
        System.out.println(minimumSizeSubarraySum_209.minSubArrayLen(s, nums));
    }
}
