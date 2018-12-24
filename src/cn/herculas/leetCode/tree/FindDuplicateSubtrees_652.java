package cn.herculas.leetCode.tree;

import java.util.*;

public class FindDuplicateSubtrees_652 {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<TreeNode> result = new ArrayList<>();
        this.preOrder(root, result, new HashMap<>());
        return result;
    }

    private String preOrder(TreeNode node, List<TreeNode> result, Map<String, Integer> map) {
        if (node == null)
            return "#";

        String serial = preOrder(node.left, result, map) + "," + preOrder(node.right, result, map) + "," + node.val;
        if (map.getOrDefault(serial, 0) == 1)
            result.add(node);
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        return serial;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(2);
        TreeNode t6 = new TreeNode(4);
        TreeNode t7 = new TreeNode(4);

        t1.left = t2;
        t1.right = t3;

        t2.left = t4;

        t3.left = t5;
        t3.right = t6;

        t5.left = t7;

        FindDuplicateSubtrees_652 findDuplicateSubtrees_652 = new FindDuplicateSubtrees_652();
        List<TreeNode> res = findDuplicateSubtrees_652.findDuplicateSubtrees(t1);

        for (TreeNode node : res) {
            System.out.print(node.val + " ");
        }
        System.out.println();
    }
}
