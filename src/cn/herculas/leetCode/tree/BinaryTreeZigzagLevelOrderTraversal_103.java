package cn.herculas.leetCode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal_103 {
    private List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        this.addToMap(root, 0);
        int size = list.size();

        List<List<Integer>> zigZagList = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            List<Integer> temp = list.get(i);
            if (i % 2 == 0) {
                zigZagList.add(temp);
            } else {
                Collections.reverse(temp);
                zigZagList.add(temp);
            }
        }
        return zigZagList;
    }

    private void addToMap (TreeNode node, int level) {
        if (node == null) {
            return;
        } else {

            try {

                ArrayList<Integer> integerArrayList = (ArrayList<Integer>) this.list.get(level);
                integerArrayList.add(node.val);

            } catch (IndexOutOfBoundsException exception) {

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
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);


        t1.left = t2;
        t1.right = t3;

        t2.left = t4;
        t3.right = t5;

        BinaryTreeZigzagLevelOrderTraversal_103 binaryTreeZigzagLevelOrderTraversal_103 = new BinaryTreeZigzagLevelOrderTraversal_103();
        List<List<Integer>> res = binaryTreeZigzagLevelOrderTraversal_103.zigzagLevelOrder(t1);

        for (List<Integer> temp: res) {
            for (int rowValue: temp) {
                System.out.print(rowValue + " ");
            }
            System.out.println();
        }
    }
}
