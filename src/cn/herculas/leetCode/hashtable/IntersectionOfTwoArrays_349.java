package cn.herculas.leetCode.hashtable;

import java.util.Arrays;
import java.util.HashSet;

public class IntersectionOfTwoArrays_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums1) set.add(num);

        HashSet<Integer> res = new HashSet<>();

        for (int num : nums2) {
            if (set.contains(num))
                res.add(num);
        }

        return res.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};

        IntersectionOfTwoArrays_349 intersectionOfTwoArrays_349 = new IntersectionOfTwoArrays_349();
        System.out.println(Arrays.toString(intersectionOfTwoArrays_349.intersection(nums1, nums2)));
    }
}
