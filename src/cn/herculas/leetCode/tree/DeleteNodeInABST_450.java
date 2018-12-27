package cn.herculas.leetCode.tree;

public class DeleteNodeInABST_450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (root.val < key) {
            root.right = this.deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = this.deleteNode(root.left, key);
        } else {
            if (root.right == null) return root.left;
            if (root.left == null) return root.right;

            TreeNode temp = root;
            root = this.min(temp.right);
            root.right = this.deleteMin(temp.right);
            root.left = temp.left;
        }

        return root;
    }

    private TreeNode min(TreeNode root) {
        if (root.left == null) return root;
        return this.min(root.left);
    }

    private TreeNode deleteMin(TreeNode root) {
        if (root.left == null) return root.right;
        root.left = this.deleteMin(root.left);
        return root;
    }

    public static void main(String[] args) {

    }
}
