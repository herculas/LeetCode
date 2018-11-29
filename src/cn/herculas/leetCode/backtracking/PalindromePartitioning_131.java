package cn.herculas.leetCode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning_131 {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s.length() == 0)
            return result;
        this.dfs(result, new ArrayList<>(), 0, s);
        return result;
    }

    // 判断字符串是否为回文串
    private boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i))
                return false;
        }
        return true;
    }

    // 深度优先搜索
    private void dfs(List<List<String>> result, List<String> temp, int index, String s) {
        if (index == s.length()) {
            List<String> co = new ArrayList<>(temp);
            result.add(co);
            return;
        }

        for (int i = index; i < s.length(); i++) {
            String substring = s.substring(index, i + 1);
            if (this.isPalindrome(substring)) {
                temp.add(substring);
                this.dfs(result, temp, i + 1, s);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String test = "aab";
        PalindromePartitioning_131 palindromePartitioning_131 = new PalindromePartitioning_131();
        List<List<String>> res = palindromePartitioning_131.partition(test);

        for (List<String> ls: res) {
            for (String s: ls) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
