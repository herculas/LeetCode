package cn.herculas.leetCode.dp;

public class LongestPalindromicSubstring_5 {
    public String longestPalindrome(String s) {
        int len = s.length();
        int maxLength = 0;

        int left = 0;
        int right = 0;

        if (len == 0) return s;
        boolean[][] isPalindrome = new boolean[len][len];

        for (int j = 0; j < len; j++) {
            isPalindrome[j][j] = true;

            for (int i = 0; i < j; i++) {
                isPalindrome[i][j] = (s.charAt(i) == s.charAt(j));
                if (j - i >= 2) {
                    isPalindrome[i][j] = isPalindrome[i][j] && isPalindrome[i + 1][j - 1];
                }

                if (isPalindrome[i][j]) {
                    if (maxLength < j - i + 1) {
                        left = i;
                        right = j;
                        maxLength = j - i + 1;
                    }
                }
            }
        }

        return s.substring(left, right + 1);
    }

    public static void main(String[] args) {
        String s = "abcda";

        LongestPalindromicSubstring_5 longestPalindromicSubstring_5 = new LongestPalindromicSubstring_5();
        System.out.println(longestPalindromicSubstring_5.longestPalindrome(s));
    }
}
