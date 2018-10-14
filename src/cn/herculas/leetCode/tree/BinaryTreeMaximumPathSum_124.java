package cn.herculas.leetCode.tree;

public class BinaryTreeMaximumPathSum_124 {

    private int max;
    /**
     * 二叉树中某一个节点为根结点的最大路径和
     * 等于该节点的节点值加上左子树和右子树的最大路径和（若为负取0）
     */
    public int maxPathSum(TreeNode root) {
        this.max = Integer.MIN_VALUE;
        this.recursive(root);
        return this.max;
    }

    private int recursive(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(0, this.recursive(root.left));
        int right = Math.max(0, this.recursive(root.right));

        this.max = Math.max(this.max, root.val + left + right);

        return Math.max(root.val, root.val + Math.max(left, right));
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(-10);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);

        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;

        BinaryTreeMaximumPathSum_124 binaryTreeMaximumPathSum_124 = new BinaryTreeMaximumPathSum_124();
        System.out.println(binaryTreeMaximumPathSum_124.maxPathSum(n1));
    }
}
