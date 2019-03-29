package cn.herculas.leetCode.linkedList;

import java.util.Stack;

public class IntersectionOfTwoLinkedLists_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode iter1 = headA;
        ListNode iter2 = headB;

        if (iter1 == null || iter2 == null) {
            return null;
        }

        while (iter1 != iter2) {
            if (iter1 == null) {
                iter1 = headB;
            } else {
                iter1 = iter1.next;
            }

            if (iter2 == null) {
                iter2 = headA;
            } else {
                iter2 = iter2.next;
            }
        }
        return iter1;
    }

    private ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode pointer1 = headA;
        ListNode pointer2 = headB;

        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();

        while (pointer1 != null) {
            stack1.push(pointer1);
            pointer1 = pointer1.next;
        }
        while (pointer2 != null) {
            stack2.push(pointer2);
            pointer2 = pointer2.next;
        }

        ListNode current = null;
        while (!stack1.empty() && !stack2.empty()) {
            if (stack1.peek() == stack2.peek()) {
                current = stack1.pop();
                stack2.pop();
            }
            if (stack1.empty() || stack2.empty()) break;
            if (stack1.peek() != stack2.peek()) break;
        }
        return current;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);

        ListNode b1 = new ListNode(3);
        ListNode b2 = new ListNode(4);
        ListNode b3 = new ListNode(5);

        ListNode c1 = new ListNode(6);
        ListNode c2 = new ListNode(7);
        ListNode c3 = new ListNode(8);

        a1.next = a2;
        a2.next = c1;

        b1.next = b2;
        b2.next = b3;
        b3.next = c1;

        c1.next = c2;
        c2.next = c3;

        IntersectionOfTwoLinkedLists_160 intersectionOfTwoLinkedLists_160 = new IntersectionOfTwoLinkedLists_160();
        ListNode head = intersectionOfTwoLinkedLists_160.getIntersectionNode2(a1, b1);

        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
