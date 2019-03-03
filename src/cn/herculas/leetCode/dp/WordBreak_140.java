package cn.herculas.leetCode.dp;

import java.util.*;

public class WordBreak_140 {
    private Map<String, List<String>> done;
    private List<String> wordDict;

        WordBreak_140() {
        this.done = new HashMap<>();
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        this.wordDict = wordDict;
        this.done.put("", new ArrayList<>());
        this.done.get("").add("");
        return this.dfs(s);
    }

    private List<String> dfs(String s) {

        if (this.done.containsKey(s)) return this.done.get(s);

        List<String> res = new ArrayList<>();

        for (int len = 1; len <= s.length(); len++) {

            String s1 = s.substring(0, len);
            String s2 = s.substring(len);

            if (this.wordDict.contains(s1)) {
                List<String> s2_res = this.dfs(s2);
                for (String item : s2_res) {
                    if (item.equals("")) {
                        res.add(s1);
                    } else {
                        res.add(s1 + " " + item);
                    }
                }
            }
        }
        this.done.put(s, res);
        return res;
    }
}
