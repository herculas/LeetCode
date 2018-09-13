package cn.herculas.leetCode.others;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement_169 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }

            if (map.get(nums[i]) > nums.length / 2) {
                return nums[i];
            }
        }

        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        int[] test = {2,2,1,1,1,2,2};

        MajorityElement_169 majorityElement_169 = new MajorityElement_169();
        System.out.println(majorityElement_169.majorityElement(test));
    }
}
