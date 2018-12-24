package cn.herculas.leetCode.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MinimumIndexSumOfTwoLists_599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        int minIndex = Integer.MAX_VALUE;

        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int index1 = map.get(list2[i]);
                int index2 = i;

                if (index1 + index2 < minIndex) {
                    res = new ArrayList<>();
                    res.add(list2[i]);
                    minIndex = index1 + index2;
                } else if (index1 + index2 == minIndex) {
                    res.add(list2[i]);
                }
            }
        }

        return res.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] list1 = {"Shogun", "KFC", "Burger King", "Tapioca Express"};
        String[] list2 = {"KFC", "Shogun", "Burger King"};

        MinimumIndexSumOfTwoLists_599 minimumIndexSumOfTwoLists_599 = new MinimumIndexSumOfTwoLists_599();
        System.out.println(Arrays.toString(minimumIndexSumOfTwoLists_599.findRestaurant(list1, list2)));
    }
}
