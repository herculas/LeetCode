package cn.herculas.leetCode.tree;

public class MaximumDepthOfBinaryTree_104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        } else if (root.left == null && root.right != null) {
            return maxDepth(root.right) + 1;
        } else if (root.left != null && root.right == null) {
            return maxDepth(root.left) + 1;
        } else if (root.left != null && root.right != null) {
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);

        t1.left = t2;
        t1.right = t3;

        t2.left = null;
        t2.right = null;

        t3.left = t4;
        t3.right = t5;

        t4.left = null;
        t4.right = null;

        t5.left = null;
        t5.right = null;

        MaximumDepthOfBinaryTree_104 maximumDepthOfBinaryTree_104 = new MaximumDepthOfBinaryTree_104();
        System.out.println(maximumDepthOfBinaryTree_104.maxDepth(t1));
    }
}
