package cn.herculas.leetCode.graph;

import java.util.*;

public class WordLadder_127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (wordList.isEmpty() || wordList.indexOf(endWord) == -1) {
            return 0;
        }

        if (beginWord.equals(endWord)) {
            return 1;
        }

        wordList.add(beginWord);

        Queue<String> strings = new LinkedList<>();
        Set<String> stringHashSet = new HashSet<>();

        strings.offer(beginWord);
        stringHashSet.add(beginWord);

        int count = 0;

        while (!strings.isEmpty()) {
            count++;

            int size = strings.size();
            for (int i = 0; i < size; i++) {
                String tempWord = strings.poll();

                for (String adj: this.getAdjacentWords(tempWord, wordList)) {
                    if (stringHashSet.contains(adj)) {
                        continue;
                    }
                    if (adj.equals(endWord)) {
                        return count + 1;
                    }
                    stringHashSet.add(adj);
                    strings.offer(adj);
                }
            }
        }

        return 0;
    }

    private List<String> getAdjacentWords(String word, List<String> dict) {
        List<String> adjacentWords = new ArrayList<>();
        for (char c = 'a'; c < 'z'; c++) {
            for (int i = 0; i < word.length(); i++) {
                if (c == word.charAt(i)) {
                    continue;
                }
                String adj = this.replace(word, i, c);

                if (dict.contains(adj)) {
                    adjacentWords.add(adj);
                }
            }
        }
        return adjacentWords;
    }

    private String replace(String s, int index, char c) {
        char[] chars = s.toCharArray();
        chars[index] = c;
        return new String(chars);
    }

    /*public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if ((beginWord == null || endWord == null) || beginWord.equals(endWord))
            return 0;

        int stringCount = 0;
        //解决重复单词问题
        Set<String> list = new HashSet<>(wordList);
        Set<String> set = new HashSet<>();
        set.add(beginWord);

        while (!set.contains(endWord)){
            Set<String> temp = new HashSet<>();
            for (String str : set){
                for (int i = 0; i < str.length(); i++) {
                    char[] chars = str.toCharArray();
                    for (int j = 97; j < 97+26; j++) {//将set中的单词字母每个替换一遍
                        chars[i] = (char)j;
                        String word = new String(chars);
                        if (list.contains(word)){//list中是否存在和set单词中相差一个字母的单词
                            list.remove(word);//存在删掉word
                            temp.add(word);
                        }
                    }
                }
            }
            if (temp.size() == 0)
                return 0;
            stringCount++;
            set = temp;
        }
        return stringCount+1;
    }*/


    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";

        List<String> wordList1 = new ArrayList<>();

        wordList1.add("hot");
        wordList1.add("dot");
        wordList1.add("dog");
        wordList1.add("lot");
        wordList1.add("log");
        wordList1.add("cog");

        List<String> wordList2 = new ArrayList<>();

        wordList2.add("hot");
        wordList2.add("dot");
        wordList2.add("dog");
        wordList2.add("lot");
        wordList2.add("log");

        WordLadder_127 wordLadder_127 = new WordLadder_127();
        System.out.println(wordLadder_127.ladderLength(beginWord, endWord, wordList1));
        System.out.println(wordLadder_127.ladderLength(beginWord, endWord, wordList2));
    }
}
