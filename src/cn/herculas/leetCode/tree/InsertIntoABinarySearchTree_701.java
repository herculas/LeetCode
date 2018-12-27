package cn.herculas.leetCode.tree;

public class InsertIntoABinarySearchTree_701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        if (root.val < val) {
            root.right = this.insertIntoBST(root.right, val);
        } else if (root.val > val) {
            root.left = this.insertIntoBST(root.left, val);
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(4);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(7);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(3);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;

        InsertIntoABinarySearchTree_701 insertIntoABinarySearchTree_701 = new InsertIntoABinarySearchTree_701();
        TreeNode res = insertIntoABinarySearchTree_701.insertIntoBST(n1, 5);

        System.out.println(res.right.left.val);
    }
}
