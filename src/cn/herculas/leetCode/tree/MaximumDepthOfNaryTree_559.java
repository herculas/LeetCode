package cn.herculas.leetCode.tree;

import java.util.Arrays;

public class MaximumDepthOfNaryTree_559 {

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        } else if (root.children == null || root.children.isEmpty()) {
            return 1;
        } else {
            int maxDepth = Integer.MIN_VALUE;
            for (Node children : root.children) {
                maxDepth = Math.max(this.maxDepth(children), maxDepth);
            }
            return maxDepth + 1;
        }
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

        MaximumDepthOfNaryTree_559 maximumDepthOfNaryTree_559 = new MaximumDepthOfNaryTree_559();
        System.out.println(maximumDepthOfNaryTree_559.maxDepth(root));
    }
}
