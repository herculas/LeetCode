package cn.herculas.leetCode.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}

public class NAryTreePreorderTraversal_589 {

    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();

        if (root == null)
            return new ArrayList<>();
        else
            res.add(root.val);

        if (root.children != null) {
            for (Node children : root.children) {
                res.addAll(this.preorder(children));
            }
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

        NAryTreePreorderTraversal_589 nAryTreePreorderTraversal_589 = new NAryTreePreorderTraversal_589();
        System.out.println(nAryTreePreorderTraversal_589.preorder(root));
    }
}
