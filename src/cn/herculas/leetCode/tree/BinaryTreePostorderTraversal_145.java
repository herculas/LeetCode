package cn.herculas.leetCode.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal_145 {
    public List<Integer> postorderTraversal(TreeNode root) {

        if (root == null)
            return new ArrayList<>();

        List<Integer> left = this.postorderTraversal(root.left);
        List<Integer> right = this.postorderTraversal(root.right);

        List<Integer> result = new ArrayList<>();

        result.addAll(left);
        result.addAll(right);
        result.add(root.val);

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

        BinaryTreePostorderTraversal_145 binaryTreePostorderTraversal_145 = new BinaryTreePostorderTraversal_145();
        System.out.println(binaryTreePostorderTraversal_145.postorderTraversal(t1));
    }
}
