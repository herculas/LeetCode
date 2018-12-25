package cn.herculas.leetCode.tree;

import java.util.Arrays;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal_106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if (inorder.length == 0)
            return null;

        int rootVal = postorder[postorder.length - 1];

        int index = 0;

        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }

        TreeNode root = new TreeNode(rootVal);
        TreeNode left = this.buildTree(Arrays.copyOfRange(inorder, 0, index), Arrays.copyOfRange(postorder, 0, index));
        TreeNode right = this.buildTree(Arrays.copyOfRange(inorder, index + 1, inorder.length), Arrays.copyOfRange(postorder, index, postorder.length - 1));

        root.left = left;
        root.right = right;

        return root;
    }

    public static void main(String[] args) {
        int[] inorder = {3,9,20,15,7};
        int[] postorder = {9,3,15,20,7};

        ConstructBinaryTreeFromInorderAndPostorderTraversal_106 constructBinaryTreeFromInorderAndPostorderTraversal_106 = new ConstructBinaryTreeFromInorderAndPostorderTraversal_106();
        TreeNode root = constructBinaryTreeFromInorderAndPostorderTraversal_106.buildTree(inorder, postorder);
    }
}
