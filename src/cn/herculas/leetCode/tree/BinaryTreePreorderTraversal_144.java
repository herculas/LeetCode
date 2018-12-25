package cn.herculas.leetCode.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal_144 {
    public List<Integer> preorderTraversal(TreeNode root) {

        if (root == null)
            return new ArrayList<>();

        List<Integer> left = this.preorderTraversal(root.left);
        List<Integer> right = this.preorderTraversal(root.right);

        List<Integer> result = new ArrayList<>();
        result.add(root.val);
        result.addAll(left);
        result.addAll(right);

        return result;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);

        n1.right = n2;
        n2.left = n3;

        BinaryTreePreorderTraversal_144 binaryTreePreorderTraversal_144 = new BinaryTreePreorderTraversal_144();
        System.out.println(binaryTreePreorderTraversal_144.preorderTraversal(n1));
    }
}
