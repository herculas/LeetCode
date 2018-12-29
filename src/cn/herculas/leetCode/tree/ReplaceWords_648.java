package cn.herculas.leetCode.tree;

import java.util.List;

class Trie {
    private class Node {
        private Node[] next = new Node[26];
        private boolean isWord = false;
    }

    private Node root;

    public void put(String word) {
        this.root = this.put(this.root, word, 0);
    }

    private Node put(Node node, String word, int d) {
        if (node == null) return new Node();
        if (d == word.length()) {
            node.isWord = true;
            return node;
        }

        int index = word.charAt(d) - 'a';
        node.next[index] = this.put(node.next[index], word, d + 1);
        return node;
    }
}

public class ReplaceWords_648 {
    public String replaceWords(List<String> dict, String sentence) {

    }

    public static void main(String[] args) {

    }
}
