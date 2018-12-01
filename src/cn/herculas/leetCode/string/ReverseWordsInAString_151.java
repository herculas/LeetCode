package cn.herculas.leetCode.string;

import java.util.ArrayList;
import java.util.List;

public class ReverseWordsInAString_151 {
    public String reverseWords(String s) {

        List<String> wordList = new ArrayList<>();

        int pointer = 0;

        s = s.trim();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (!s.substring(pointer, i).equals(""))
                    wordList.add(s.substring(pointer, i));
                pointer = i + 1;
            }
        }
        wordList.add(s.substring(pointer));
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = wordList.size() - 1; i >= 0; i--) {
            stringBuilder.append(wordList.get(i));
            stringBuilder.append(' ');
        }

        return stringBuilder.toString().trim();
    }

    public static void main(String[] args) {
        String s = "the sky is blue";
        ReverseWordsInAString_151 reverseWordsInAString_151 = new ReverseWordsInAString_151();
        System.out.println(reverseWordsInAString_151.reverseWords(s));
    }
}
