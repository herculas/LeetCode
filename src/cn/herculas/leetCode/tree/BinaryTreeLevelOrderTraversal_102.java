package cn.herculas.leetCode.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal_102 {
    private List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        this.addToMap(root, 0);
        return this.list;
    }

    private void addToMap (TreeNode node, int level) {
        if (node == null) {
            return;
        } else {
            try {
                ArrayList<Integer> temp = (ArrayList<Integer>) this.list.get(level);
                temp.add(node.val);
            } catch (IndexOutOfBoundsException e) {
                ArrayList<Integer> add = new ArrayList<>();
                add.add(node.val);
                this.list.add(level, add);
            }
        }
        if (node.left != null) {
            this.addToMap(node.left, level + 1);
        }
        if (node.right != null) {
            this.addToMap(node.right, level + 1);
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);

        TreeNode t6 = new TreeNode(25);
        TreeNode t7 = new TreeNode(27);

        t1.left = t2;
        t1.right = t3;

        t3.left = t4;
        t3.right = t5;

        t2.left = t6;
        t2.right = t7;

        BinaryTreeLevelOrderTraversal_102 binaryTreeLevelOrderTraversal_102 = new BinaryTreeLevelOrderTraversal_102();
        List<List<Integer>> lists = binaryTreeLevelOrderTraversal_102.levelOrder(t1);

        for (List<Integer> temp: lists) {
            for (int rowValue: temp) {
                System.out.print(rowValue + " ");
            }
            System.out.println();
        }
    }
}
