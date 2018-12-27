package cn.herculas.leetCode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTreeIterator_173 {

    private Queue<Integer> iterator;

    public BinarySearchTreeIterator_173(TreeNode root) {
        this.iterator = new LinkedList<>();
        if (root != null) this.inOrder(root);
    }

    private void inOrder(TreeNode root) {
        if (root.left != null) this.inOrder(root.left);
        this.iterator.add(root.val);
        if (root.right != null) this.inOrder(root.right);
    }

    /** @return the next smallest number */
    public int next() {
        return this.iterator.poll();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !this.iterator.isEmpty();
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(7);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(9);
        TreeNode node5 = new TreeNode(20);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        BinarySearchTreeIterator_173 iterator = new BinarySearchTreeIterator_173(node1);

        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
    }
}
