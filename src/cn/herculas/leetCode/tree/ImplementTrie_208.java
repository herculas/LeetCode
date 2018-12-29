package cn.herculas.leetCode.tree;

class TrieNode {
    boolean isWord = false;
    TrieNode[] next = new TrieNode[26];
}

public class ImplementTrie_208 {

    private TrieNode root;

    public ImplementTrie_208() {

    }

    public void insert(String word) {
        this.root = this.insert(this.root, word, 0);
    }

    private TrieNode insert(TrieNode node, String word, int d) {
        if (node == null) node = new TrieNode();
        if (d == word.length()) {
            node.isWord = true;
            return node;
        }

        int character = word.charAt(d) - 'a';
        node.next[character] = this.insert(node.next[character], word, d + 1);
        return node;
    }

    public boolean search(String word) {
        TrieNode res = this.search(this.root, word, 0);
        if (res == null) return false;
        return res.isWord;
    }

    private TrieNode search(TrieNode node, String word, int d) {
        if (node == null) return null;
        if (d == word.length()) return node;

        int character = word.charAt(d) - 'a';
        return this.search(node.next[character], word, d + 1);
    }

    public boolean startsWith(String prefix) {
        TrieNode res = this.search(this.root, prefix, 0);
        return res != null;
    }

    public static void main(String[] args) {
        ImplementTrie_208 trie = new ImplementTrie_208();

        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}
