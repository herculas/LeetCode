package cn.herculas.leetCode.array;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence_128 {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (m.containsKey(num)) continue;
            int left = m.getOrDefault(num - 1, 0);
            int right = m.getOrDefault(num + 1, 0);
            int sum = left + right + 1;
            m.put(num, sum);
            res = Math.max(res, sum);
            m.put(num - left, sum);
            m.put(num + right, sum);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = {100, 4, 200, 1, 3, 2};
        LongestConsecutiveSequence_128 longestConsecutiveSequence_128 = new LongestConsecutiveSequence_128();
        System.out.println(longestConsecutiveSequence_128.longestConsecutive(test));
    }
}
