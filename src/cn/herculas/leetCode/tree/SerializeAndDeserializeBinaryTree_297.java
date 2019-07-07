package cn.herculas.leetCode.tree;

import java.util.*;

public class SerializeAndDeserializeBinaryTree_297 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        this.generateSerial(root, sb);
        return sb.toString();
    }

    private void generateSerial(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append('#').append(',');
            return;
        }
        sb.append(node.val).append(',');
        this.generateSerial(node.left, sb);
        this.generateSerial(node.right, sb);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> strings = new LinkedList<>(Arrays.asList(data.split(",")));

        return this.buildTree(strings);
    }

    public TreeNode buildTree(Queue<String> stringQueue) {
        String string = stringQueue.poll();
        if (string.equals("#")) {
            return null;
        }

        TreeNode treeNode = new TreeNode(Integer.valueOf(string));
        treeNode.left = buildTree(stringQueue);
        treeNode.right = buildTree(stringQueue);

        return treeNode;
    }


    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);

        t1.left = t2;
        t1.right = t3;

        t2.left = t4;
        t2.right = t5;

        t3.left = t6;
        t3.right = t7;

        SerializeAndDeserializeBinaryTree_297 serializeAndDeserializeBinaryTree_297 = new SerializeAndDeserializeBinaryTree_297();
        String serial = serializeAndDeserializeBinaryTree_297.serialize(t1);
        System.out.println(serial);

        TreeNode treeNode = serializeAndDeserializeBinaryTree_297.deserialize(serial);
    }
}
