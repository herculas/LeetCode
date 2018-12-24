package cn.herculas.leetCode.hashtable;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum_1 {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                res[0] = map.get(nums[i]);
                res[1] = i;
                return res;
            } else {
                map.put(target - nums[i], i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;

        TwoSum_1 twoSum_1 = new TwoSum_1();
        System.out.println(Arrays.toString(twoSum_1.twoSum(nums, target)));
    }
}
