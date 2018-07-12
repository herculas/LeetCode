package cn.herculas.leetCode.string;

import java.util.HashMap;

public class ValidAnagram_242 {
    public boolean isAnagram(String s, String t) {
        int size1 = s.length();
        int size2 = t.length();

        if (size1 != size2) {
            return false;
        }

        HashMap<Character, Integer> hashMap1 = new HashMap<>();
        HashMap<Character, Integer> hashMap2 = new HashMap<>();

        char temp1;
        char temp2;

        for (int i = 0; i < size1; i++) {
            temp1 = s.charAt(i);
            temp2 = t.charAt(i);

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
        String s1 = "anagram";
        String t1 = "nagaram";

        String s2 = "rat";
        String t2 = "car";

        ValidAnagram_242 validAnagram_242 = new ValidAnagram_242();
        System.out.println(validAnagram_242.isAnagram(s2, t2));
    }
}
