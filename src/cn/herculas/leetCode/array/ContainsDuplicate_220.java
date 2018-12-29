package cn.herculas.leetCode.array;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class ContainsDuplicate_220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k <= 0 || t < 0) return false;
        TreeSet<Long> tree = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long x = tree.ceiling((long) nums[i] - t);
            if (x != null && x <= (long) nums[i] + t) return true;
            if (i >= k)
                tree.remove((long) nums[i - k]);
            tree.add((long) nums[i]);
        }
        return false;
    }


    public static void main(String[] args) {
        int[] nums = {1,0,1,1};

        ContainsDuplicate_220 containsDuplicate_220 = new ContainsDuplicate_220();
        System.out.println(containsDuplicate_220.containsNearbyAlmostDuplicate(nums, 1, 2));
    }
}
