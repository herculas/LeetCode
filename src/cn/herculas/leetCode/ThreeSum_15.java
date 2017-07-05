package cn.herculas.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wurah on 2017/7/4.
 */
public class ThreeSum_15 {
    public static List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);

        List<List<Integer>> res;
        res = new ArrayList<>();

        for (int i = 0 ; i < nums.length - 2; i++){
            //skip same result
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }

            int j = i + 1;
            int k = nums.length - 1;
            int target = -nums[i];

            while (j < k){
                if (nums[j] + nums[k] == target){
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;

                    //skip same result
                    while (j < k && nums[j] == nums[j - 1]){
                        j++;
                    }

                    //skip same result
                    while (j < k && nums[k] == nums[k + 1]){
                        k--;
                    }
                }

                else if (nums[j] + nums[k] > target){
                    k--;
                }
                else {
                    j++;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] s = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = threeSum(s);
        System.out.println(res);
    }
}
