package cn.herculas.leetCode.hashtable;

import java.util.HashMap;

public class ContainsDuplicate_219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) {
                    return true;
                } else {
                    map.put(nums[i], i);
                }
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,1,1};
        int k = 1;

        ContainsDuplicate_219 containsDuplicate_219 = new ContainsDuplicate_219();
        System.out.println(containsDuplicate_219.containsNearbyDuplicate(nums, k));
    }
}
