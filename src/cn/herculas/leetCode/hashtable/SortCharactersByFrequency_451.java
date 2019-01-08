package cn.herculas.leetCode.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SortCharactersByFrequency_451 {
    public String frequencySort(String s) {

        Map<Character, Integer> characterCount = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (characterCount.containsKey(s.charAt(i))) {
                characterCount.put(s.charAt(i), characterCount.get(s.charAt(i)) + 1);
            } else {
                characterCount.put(s.charAt(i), 1);
            }
        }

        Map<Integer, Set<Character>> countMap = new HashMap<>();

        for (Character c : characterCount.keySet()) {
            int countOfC = characterCount.get(c);

            if (countMap.containsKey(countOfC)) {
                Set<Character> nodesWithCountOfC = countMap.get(countOfC);
                nodesWithCountOfC.add(c);

            } else {
                Set<Character> nodesWithCountOfC = new HashSet<>();
                nodesWithCountOfC.add(c);
                countMap.put(countOfC, nodesWithCountOfC);
            }
        }

        StringBuilder res = new StringBuilder();
        for (Integer i : countMap.keySet()) {
            for (Character c : countMap.get(i)) {
                for (int j = 0; j < i; j++) {
                    res.insert(0, c);
                }
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        SortCharactersByFrequency_451 sortCharactersByFrequency_451 = new SortCharactersByFrequency_451();
        System.out.println(sortCharactersByFrequency_451.frequencySort("tree"));
    }
}
