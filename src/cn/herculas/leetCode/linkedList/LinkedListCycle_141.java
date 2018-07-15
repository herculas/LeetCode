package cn.herculas.leetCode.linkedList;

public class LinkedListCycle_141 {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        if (head.next == head) {
            return true;
        }

        ListNode pointer = head;
        ListNode next = head.next;

        while (pointer != null) {
            if (pointer.next != head) {
                pointer.next = head;
                pointer = next;

                if (next != null) {
                    next = next.next;
                }
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(1);
        ListNode l7 = new ListNode(2);
        ListNode l8 = new ListNode(3);
        ListNode l9 = new ListNode(4);
        ListNode l10 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;
        l8.next = l9;
        l9.next = l10;
        l10.next = null;

        LinkedListCycle_141 linkedListCycle_141 = new LinkedListCycle_141();
        System.out.println(linkedListCycle_141.hasCycle(l1));
    }
}
