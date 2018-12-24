package cn.herculas.leetCode.hashtable;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones_771 {
    public int numJewelsInStones(String J, String S) {
        Set<Character> jewels = new HashSet<>();

        for (int i = 0; i < J.length(); i++) {
            jewels.add(J.charAt(i));
        }

        int res = 0;

        for (int i = 0; i < S.length(); i++) {
            if (jewels.contains(S.charAt(i)))
                res++;
        }

        return res;
    }

    public static void main(String[] args) {
        String J = "aA";
        String S = "aAAbbbb";

        JewelsAndStones_771 jewelsAndStones_771 = new JewelsAndStones_771();
        System.out.println(jewelsAndStones_771.numJewelsInStones(J, S));
    }
}
