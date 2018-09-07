package cn.herculas.leetCode.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        if (root.left != null) {
            left = this.inorderTraversal(root.left);
        }

        if (root.right != null) {
            right = this.inorderTraversal(root.right);
        }

        List<Integer> result = new ArrayList<>();

        result.addAll(left);
        result.add(root.val);
        result.addAll(right);

        return result;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);

        t1.left = null;
        t1.right = t2;

        t2.left = t3;
        t2.right = null;

        BinaryTreeInorderTraversal_94 binaryTreeInorderTraversal_94 = new BinaryTreeInorderTraversal_94();
        System.out.println(binaryTreeInorderTraversal_94.inorderTraversal(t1));

    }
}
