package cn.herculas.leetCode;

import java.util.Arrays;

/**
 * Created by wurah on 2017/7/5.
 */
public class ThreeSumClosest_16 {
    public static int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int distance = Integer.MAX_VALUE;
        int closet = 0;

        for (int i = 0; i < nums.length - 2; ++i){

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum > target){
                    k--;
                }
                else {
                    j++;
                }
                if(Math.abs(sum - target) < distance){
                    distance = Math.abs(sum - target);
                    closet = sum;
                }
            }
        }
        return closet;
    }

    public static void main(String[] args) {
        int[] test = {-1, 2, 1, -4};
        int target = 1;
        int res = threeSumClosest(test, target);
        System.out.println(res);
    }
}
