package cn.herculas.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wurah on 2017/7/5.
 */
public class FourSum_18 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        if(nums.length < 4)
            return res;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; ++i){
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target)
                break;
            if (nums[i] + nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] < target)
                continue;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < nums.length - 2; ++j){
                if(nums[i] + nums[j] +nums[j + 1] + nums[j + 2] > target)
                    break;
                if(nums[i] + nums[j] +nums[nums.length - 1] + nums[nums.length -2] < target)
                    continue;
                if(j > i + 1 && nums[j] == nums[j - 1])
                    continue;

                int left = j + 1;
                int right = nums.length - 1;

                while (left < right){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];

                    if(sum == target){
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        while (left < right && nums[left] == nums[left + 1]){
                            left ++;
                        }
                        while (left < right && nums[right] == nums[right - 1]){
                            right --;
                        }

                        left ++;
                        right --;
                    }
                    else if(sum > target){
                        right --;
                    }
                    else {
                        left ++;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] S = {1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> Con = fourSum(S,target);
        System.out.println(Con);
    }
}

