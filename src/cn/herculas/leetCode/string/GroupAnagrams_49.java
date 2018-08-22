package cn.herculas.leetCode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> outerList = new ArrayList<>();

        int size = strs.length;
        if (size == 0) {
            return outerList;
        }

        for (String str : strs) {

            if (outerList.size() == 0) {
                List<String> tempList = new ArrayList<>();
                tempList.add(str);
                outerList.add(tempList);
                continue;
            }

            boolean done = false;

            for (List<String> anOuterList : outerList) {
                String flagString = anOuterList.get(0);
                if (isAnagram(flagString, str)) {
                    anOuterList.add(str);
                    done = true;
                }
            }

            if (!done) {
                List<String> tempAddList = new ArrayList<>();
                tempAddList.add(str);
                outerList.add(tempAddList);
            }
        }

        return outerList;
    }

    private boolean isAnagram(String str1, String str2) {

        int sizeA = str1.length();
        int sizeB = str2.length();

        if (sizeA != sizeB) {
            return false;
        }

        HashMap<Character, Integer> hashMap1 = new HashMap<>();
        HashMap<Character, Integer> hashMap2 = new HashMap<>();

        char temp1;
        char temp2;

        for (int i = 0; i < sizeA; i++) {
            temp1 = str1.charAt(i);
            temp2 = str2.charAt(i);

            if (hashMap1.containsKey(temp1)) {
                hashMap1.put(temp1, hashMap1.get(temp1) + 1);
            } else {
                hashMap1.put(temp1, 1);
            }

            if (hashMap2.containsKey(temp2)) {
                hashMap2.put(temp2, hashMap2.get(temp2) + 1);
            } else {
                hashMap2.put(temp2, 1);
            }
        }

        return hashMap1.equals(hashMap2);
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams_49 groupAnagrams_49 = new GroupAnagrams_49();
        System.out.println(groupAnagrams_49.groupAnagrams(strs));
    }
}
