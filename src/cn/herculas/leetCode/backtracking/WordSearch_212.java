package cn.herculas.leetCode.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Node {
    boolean stringMark;
    Node[] next = new Node[26];
}

class Trie {
    private Node root;

    Trie() {
        this.root = new Node();
    }

    public boolean get(String key) {
        Node x = get(this.root, key, 0);
        if (x == null)
            return false;
        return x.stringMark;
    }

    private Node get(Node x, String key, int d) {
        if (x == null)
            return null;
        if (d == key.length())
            return x;

        int charIndex = key.charAt(d) - 'a';
        return get(x.next[charIndex], key, d + 1);
    }

    public void put(String key) {
        root = put(root, key, 0);
    }

    private Node put(Node x, String key, int d) {
        if (x == null)
            x = new Node();

        if (d == key.length()) {
            x.stringMark = true;
            return x;
        }

        int charIndex = key.charAt(d) - 'a';
        x.next[charIndex] = put(x.next[charIndex], key, d + 1);
        return x;
    }

    boolean startsWith(String prefix) {
        Node x = get(this.root, prefix, 0);
        return x != null;
    }
}

public class WordSearch_212 {

    private Set<String> prefixSet = new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();

        int sizeY = board.length;
        int sizeX = board[0].length;

        if (sizeX == 0 || words.length == 0) {
            return result;
        }

        Trie trie = new Trie();
        for (String word : words) {
            trie.put(word);
        }

        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                char temp = board[i][j];
                board[i][j] = '0';
                this.findWord(board, String.valueOf(temp), i, j, trie);
                board[i][j] = temp;
            }
        }

        for (String word : words) {
            if (prefixSet.contains(word) && !result.contains(word))
                result.add(word);
        }
        return result;
    }

    private void findWord(char[][] board, String prefix, int i, int j, Trie trie) {
        if (trie.get(prefix))
            prefixSet.add(prefix);

        if (trie.startsWith(prefix)) {
            int[] di = {0, 1, 0, -1};
            int[] dj = {1, 0, -1, 0};

            for (int k = 0; k < 4; k++) {
                int newI = i + di[k];
                int newJ = j + dj[k];
                if (newI >= 0 && newI < board.length && newJ >= 0 && newJ < board[0].length && board[newI][newJ] != '0') {
                    char temp = board[newI][newJ];
                    board[newI][newJ] = '0';
                    this.findWord(board, prefix + temp, newI, newJ, trie);
                    board[newI][newJ] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] board1 = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };

        char[][] board2 = {{'a', 'a'}};

        String[] words1 = {"oath", "pea", "eat", "rain"};
        String[] words2 = {"a"};

        WordSearch_212 wordSearch_212 = new WordSearch_212();
        List<String> result = wordSearch_212.findWords(board2, words2);

        for (String s: result) {
            System.out.print(s + " ");
        }
    }
}
