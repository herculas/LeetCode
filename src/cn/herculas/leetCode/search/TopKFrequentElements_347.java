package cn.herculas.leetCode.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements_347 {

    public List<Integer> topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> integerHashMap = new HashMap<>();

        // Construct map for number and frequency
        for (Integer num : nums) {
            if (integerHashMap.containsKey(num)) {
                integerHashMap.put(num, integerHashMap.get(num) + 1);
            } else {
                integerHashMap.put(num, 1);
            }
        }

        // Calculate the maximum of frequency
        int maxFreq = 0;
        for (Map.Entry<Integer, Integer> index : integerHashMap.entrySet()) {
            maxFreq = Math.max(maxFreq, index.getValue());
        }

        // Initialize an array of ArrayList
        // whose index is frequency and values are list of numbers
        List<Integer>[] lists = new ArrayList[maxFreq + 1];
        for (int i = 1; i <= maxFreq; i++) {
            lists[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> index : integerHashMap.entrySet()) {
            lists[index.getValue()].add(index.getKey());
        }

        List<Integer> result = new ArrayList<>();
        for (int i = maxFreq; i >= 1; i--) {
            boolean flag = false;

            if (lists[i].size() > 0) {
                for (Integer index: lists[i]) {
                    result.add(index);

                    if (result.size() == k) {
                        flag = true;
                    }
                }
            }
            if (flag) {
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 2, 2, 3};
        int k = 2;

        TopKFrequentElements_347 topKFrequentElements_347 = new TopKFrequentElements_347();
        System.out.println(topKFrequentElements_347.topKFrequent(numbers, k));

    }
}
