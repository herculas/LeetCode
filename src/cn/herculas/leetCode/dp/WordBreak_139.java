package cn.herculas.leetCode.dp;

import java.util.Arrays;
import java.util.List;

public class WordBreak_139 {

    /**
     * 超时做法
     * @param s
     * @param wordDict
     * @return
     */
//    public boolean wordBreak(String s, List<String> wordDict) {
//        if (s.length() == 0) return true;
//
//        boolean result = false;
//
//        for (int i = 1; i <= s.length(); i++) {
//            String s1 = s.substring(0, i);
//            String s2 = s.substring(i);
//
//            if (wordDict.contains(s1)) {
//                boolean roundRes = this.wordBreak(s2, wordDict);
//                result = result | roundRes;
//            }
//        }
//
//        return result;
//    }

    /**
     * 动态规划
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {

        int n = s.length();
        boolean[] memo = new boolean[n + 1];

        int maxLength = Integer.MIN_VALUE;
        for (String word : wordDict) {
            maxLength = Math.max(maxLength, word.length());
        }

        memo[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = Math.max(i - maxLength, 0); j < i; j++) {
                if (memo[j] && wordDict.contains(s.substring(j, i))) {
                    memo[i] = true;
                    break;
                }
            }
        }
        return memo[n];
    }

    public static void main(String[] args) {
        String s = "catsandog";
        List wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");

        WordBreak_139 wordBreak_139 = new WordBreak_139();
        System.out.println(wordBreak_139.wordBreak(s, wordDict));
    }
}
