package cn.herculas.leetCode.string;

import java.util.ArrayList;
import java.util.List;

public class ReverseWordsInAString_557 {
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

        for (String s1 : wordList) {
            stringBuilder.append(new StringBuffer(s1).reverse());
            stringBuilder.append(' ');
        }

        return stringBuilder.toString().trim();
    }

    public static void main(String[] args) {
        ReverseWordsInAString_557 reverseWordsInAString_557 = new ReverseWordsInAString_557();
        System.out.println(reverseWordsInAString_557.reverseWords("Let's take LeetCode contest"));
    }
}
