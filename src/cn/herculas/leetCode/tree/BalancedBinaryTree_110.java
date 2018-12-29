package cn.herculas.leetCode.tree;

public class BalancedBinaryTree_110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (root.left != null && !this.isBalanced(root.left)) return false;
        if (root.right != null && !this.isBalanced(root.right)) return false;

        return Math.abs(this.height(root.left) - this.height(root.right)) <= 1;
    }

    private int height(TreeNode root) {
        if (root == null) return 0;
        return Math.max(this.height(root.left), this.height(root.right)) + 1;
    }
}
