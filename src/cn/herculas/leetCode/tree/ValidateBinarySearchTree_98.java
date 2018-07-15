package cn.herculas.leetCode.tree;

public class ValidateBinarySearchTree_98 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            return true;
        } else if (root.left == null && root.right != null) {
            return isValidBST(root.right) & isMoreThanRoot(root.val, root.right);
        } else if (root.left != null && root.right == null) {
            return isValidBST(root.left) & isLessThanRoot(root.val, root.left);
        } else if (root.left != null && root.right != null) {
            return isValidBST(root.right) & isMoreThanRoot(root.val, root.right) &
                    isValidBST(root.left) & isLessThanRoot(root.val, root.left);
        }
        return true;
    }

    private boolean isLessThanRoot (int value, TreeNode root) {
        if (value <= root.val) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return true;
        } else if (root.left == null && root.right != null) {
            return isLessThanRoot(value, root.right);
        } else if (root.left != null && root.right == null) {
            return isLessThanRoot(value, root.left);
        } else if (root.left != null && root.right != null) {
            return isLessThanRoot(value, root.right) & isLessThanRoot(value, root.left);
        }
        return true;
    }

    private boolean isMoreThanRoot (int value, TreeNode root) {
        if (value >= root.val) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return true;
        } else if (root.left == null && root.right != null) {
            return isMoreThanRoot(value, root.right);
        } else if (root.left != null && root.right == null) {
            return isMoreThanRoot(value, root.left);
        } else if (root.left != null && root.right != null) {
            return isMoreThanRoot(value, root.right) & isMoreThanRoot(value, root.left);
        }
        return true;
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

        ValidateBinarySearchTree_98 validateBinarySearchTree_98 = new ValidateBinarySearchTree_98();
        System.out.println(validateBinarySearchTree_98.isValidBST(t21));
    }
}
