package cn.herculas.leetCode.tree;

class TrieCharacterNode {
    int value;
    TrieCharacterNode[] next = new TrieCharacterNode[26];
}

public class MapSumPairs_677 {

    private TrieCharacterNode root;

    public void insert(String word, int value) {
        this.root = this.insert(this.root, word, value, 0);
    }

    private TrieCharacterNode insert(TrieCharacterNode node, String word, int value, int d) {
        if (node == null) node = new TrieCharacterNode();
        if (d == word.length()) {
            node.value = value;
            return node;
        }

        int character = word.charAt(d) - 'a';
        node.next[character] = this.insert(node.next[character], word, value, d + 1);
        return node;
    }

    public int sum(String prefix) {

        TrieCharacterNode temp = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            if (temp.next[prefix.charAt(i) - 'a'] == null)
                return 0;
            temp = temp.next[prefix.charAt(i) - 'a'];

        }
        return dfs(temp);
    }

    private int dfs(TrieCharacterNode node) {

        int sum = 0;
        for (TrieCharacterNode t : node.next)
            if (t != null)
                sum += dfs(t);
        return sum + node.value;
    }


    public static void main(String[] args) {
        MapSumPairs_677 mapSumPairs_677 = new MapSumPairs_677();

        mapSumPairs_677.insert("apple", 3);
        System.out.println(mapSumPairs_677.sum("ap"));
        mapSumPairs_677.insert("app", 2);
        System.out.println(mapSumPairs_677.sum("ap"));
    }
}
