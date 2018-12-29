package cn.herculas.leetCode.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NAryTreeLevelOrderTraversal_429 {
    public List<List<Integer>> levelOrder(Node root) {

        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Node> thisLevel = new ArrayList<>();
        thisLevel.add(root);
        List<Integer> first = Arrays.asList(root.val);
        res.add(first);

        while (!thisLevel.isEmpty()) {
            List<Node> nextLevel = new ArrayList<>();
            for (Node node : thisLevel) {
                if (node.children != null)
                    nextLevel.addAll(node.children);
            }
            List<Integer> level = new ArrayList<>();
            for (Node node : nextLevel) {
                level.add(node.val);
            }
            if (!level.isEmpty())
                res.add(level);

            thisLevel = nextLevel;
        }
        return res;
    }

    public static void main(String[] args) {
        Node root = new Node(1, null);
        Node n11 = new Node(3, null);
        Node n12 = new Node(2, null);
        Node n13 = new Node(4, null);

        Node n21 = new Node(5, null);
        Node n22 = new Node(6, null);

        root.children = Arrays.asList(n11, n12, n13);
        n11.children = Arrays.asList(n21, n22);

        NAryTreeLevelOrderTraversal_429 nAryTreeLevelOrderTraversal_429 = new NAryTreeLevelOrderTraversal_429();
        System.out.println(nAryTreeLevelOrderTraversal_429.levelOrder(root));
    }
}
