package cn.herculas.leetCode.linkedList;

public class OddEvenLinkedList_328 {
    public ListNode oddEvenList(ListNode head) {
        int count = 0;
        ListNode iter = head;

        ListNode l1 = null;
        ListNode l2 = null;

        ListNode head1 = null;
        ListNode head2 = null;

        while (iter != null) {
            if (count % 2 == 0) {
                ListNode temp = new ListNode(iter.val);
                if (l1 == null) {
                    l1 = temp;
                    head1 = l1;
                } else {
                    l1.next = temp;
                    l1 = l1.next;
                }
            } else {
                ListNode temp = new ListNode(iter.val);
                if (l2 == null) {
                    l2 = temp;
                    head2 = l2;
                } else {
                    l2.next = temp;
                    l2 = l2.next;
                }
            }
            count++;
            iter = iter.next;
        }

        if (l1 != null) {
            l1.next = head2;
            return head1;
        } else {
            return head2;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);
        ListNode l7 = new ListNode(7);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = null;

        OddEvenLinkedList_328 oddEvenLinkedList_328 = new OddEvenLinkedList_328();
        ListNode head = oddEvenLinkedList_328.oddEvenList(l1);

        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
    }
}
