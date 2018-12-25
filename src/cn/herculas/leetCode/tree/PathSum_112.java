package cn.herculas.leetCode.tree;

public class PathSum_112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;

        if (root.left == null && root.right == null)
            return root.val == sum;

        return this.hasPathSum(root.left, sum - root.val) || this.hasPathSum(root.right, sum - root.val);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(8);
        TreeNode n4 = new TreeNode(11);
        TreeNode n5 = new TreeNode(13);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(2);
        TreeNode n9 = new TreeNode(1);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;

        n3.left = n5;
        n3.right = n6;

        n4.left = n7;
        n4.right = n8;

        n6.right = n9;

        PathSum_112 pathSum_112 = new PathSum_112();
        System.out.println(pathSum_112.hasPathSum(n1, 27));
    }
}
