package cn.herculas.leetCode.tree;

public class KthSmallestElementInABst_230 {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        int leftSize = this.treeSize(root.left);
        if (leftSize > k - 1) {
            return this.kthSmallest(root.left, k);
        } else if (leftSize < k - 1) {
            return this.kthSmallest(root.right, k - leftSize - 1);
        } else {
            return root.val;
        }
    }

    private int treeSize(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return this.treeSize(root.left) + this.treeSize(root.right) + 1;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(1);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node4.left = node6;

        KthSmallestElementInABst_230 kthSmallestElementInABst_230
                = new KthSmallestElementInABst_230();
        System.out.println(kthSmallestElementInABst_230.kthSmallest(node1, 3));
    }
}
