package cn.herculas.leetCode.linkedList;

import java.util.Stack;

public class SwapNodesInPairs_24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        Stack<ListNode> nodeStack = new Stack<>();
        ListNode ptr = head;
        ListNode tail = new ListNode(10000);
        ListNode newHead = tail;

        while (ptr != null) {
            if (nodeStack.size() == 2) {
                ListNode node1 = nodeStack.pop();
                ListNode node2 = nodeStack.pop();
                tail.next = node1;
                node1.next = node2;
                tail = node2;
            }
            nodeStack.push(ptr);
            ptr = ptr.next;
        }
        while (!nodeStack.empty()) {
            tail.next = nodeStack.pop();
            tail = tail.next;
        }
        tail.next = null;
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        SwapNodesInPairs_24 swapNodesInPairs_24 = new SwapNodesInPairs_24();
        ListNode head = swapNodesInPairs_24.swapPairs(node1);

        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("null");
    }
}
