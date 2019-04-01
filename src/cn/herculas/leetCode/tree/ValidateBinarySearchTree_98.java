package cn.herculas.leetCode.tree;

public class ValidateBinarySearchTree_98 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        boolean result = true;
        if (root.left != null) result = this.isValidBST(root.left) && this.isLessThanRoot(root.val, root.left);
        if (root.right != null) result = result && this.isValidBST(root.right) && this.isMoreThanRoot(root.val, root.right);
        return result;
    }

    private boolean isLessThanRoot(int val, TreeNode root) {
        boolean result = root.val < val;
        if (root.left != null) result = result && this.isLessThanRoot(val, root.left);
        if (root.right != null) result = result && this.isLessThanRoot(val, root.right);
        return result;
    }

    private boolean isMoreThanRoot(int val, TreeNode root) {
        boolean result = root.val > val;
        if (root.left != null) result = result && this.isMoreThanRoot(val, root.left);
        if (root.right != null) result = result && this.isMoreThanRoot(val, root.right);
        return result;
    }

    public static void main(String[] args) {
        TreeNode t11 = new TreeNode(5);
        TreeNode t12 = new TreeNode(1);
        TreeNode t13 = new TreeNode(4);
        TreeNode t14 = new TreeNode(3);
        TreeNode t15 = new TreeNode(6);

        t11.left = t12;
        t11.right = t13;

        t13.left = t14;
        t13.right = t15;

        TreeNode t21 = new TreeNode(2);
        TreeNode t22 = new TreeNode(1);
        TreeNode t23 = new TreeNode(3);

        t21.left = t22;
        t21.right = t23;

        TreeNode t31 = new TreeNode(5);
        TreeNode t32 = new TreeNode(14);
        TreeNode t33 = new TreeNode(1);

        t31.left = t32;
        t32.left = t33;

        ValidateBinarySearchTree_98 validateBinarySearchTree_98 = new ValidateBinarySearchTree_98();
        System.out.println(validateBinarySearchTree_98.isValidBST(t11));
        System.out.println(validateBinarySearchTree_98.isValidBST(t21));
        System.out.println(validateBinarySearchTree_98.isValidBST(t31));
    }
}
