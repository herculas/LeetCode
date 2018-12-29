package cn.herculas.leetCode.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NAryTreePostorderTraversal_590 {

    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();

        if (root == null)
            return new ArrayList<>();

        if (root.children != null) {
            for (Node children : root.children) {
                res.addAll(this.postorder(children));
            }
        }
        res.add(root.val);
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

        NAryTreePostorderTraversal_590 nAryTreePostorderTraversal_590 = new NAryTreePostorderTraversal_590();
        System.out.println(nAryTreePostorderTraversal_590.postorder(root));
    }
}
