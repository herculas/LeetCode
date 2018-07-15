package cn.herculas.leetCode.tree;

public class SymmetricTree_101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isMirror(root.left, root.right);
    }

    private boolean isMirror (TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }

        if (left.val != right.val) {
            return false;
        }

        return isMirror(left.left, right.right) & isMirror(left.right, right.left);

    }

    public static void main(String[] args) {
        TreeNode t11 = new TreeNode(1);
        TreeNode t12 = new TreeNode(2);
        TreeNode t13 = new TreeNode(2);
        TreeNode t14 = new TreeNode(3);
        TreeNode t15 = new TreeNode(4);
        TreeNode t16 = new TreeNode(4);
        TreeNode t17 = new TreeNode(3);


        t11.left = t12;
        t11.right = t13;

        t12.left = t14;
        t12.right = t15;

        t13.left = t16;
        t13.right = t17;

        TreeNode t21 = new TreeNode(1);
        TreeNode t22 = new TreeNode(2);
        TreeNode t23 = new TreeNode(2);
        TreeNode t24 = new TreeNode(3);
        TreeNode t25 = new TreeNode(3);

        t21.left = t22;
        t21.right = t23;

        t22.right = t24;

        t23.right = t25;
        SymmetricTree_101 symmetricTree_101 = new SymmetricTree_101();
        System.out.println(symmetricTree_101.isSymmetric(t21));
    }
}
