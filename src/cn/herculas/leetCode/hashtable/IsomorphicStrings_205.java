package cn.herculas.leetCode.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicStrings_205 {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> characterMap = new HashMap<>();
        Set<Character> characterSet = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            if (characterMap.containsKey(s.charAt(i))) {
                if (characterMap.get(s.charAt(i)) != t.charAt(i))
                    return false;
            } else {
                if (characterSet.contains(t.charAt(i))) {
                    return false;
                } else {
                    characterMap.put(s.charAt(i), t.charAt(i));
                    characterSet.add(t.charAt(i));
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "paper";
        String t = "title";

        IsomorphicStrings_205 isomorphicStrings_205 = new IsomorphicStrings_205();
        System.out.println(isomorphicStrings_205.isIsomorphic(s, t));
    }
}
