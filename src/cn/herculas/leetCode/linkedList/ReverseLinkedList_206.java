package cn.herculas.leetCode.linkedList;

public class ReverseLinkedList_206 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode pre = head;
        ListNode now = head.next;
        ListNode suf;

        if (head.next == null) {
            return head;
        } else {
            suf = head.next.next;
        }

        head.next = null;
        while (suf != null) {
            now.next = pre;

            pre = now;
            now = suf;
            suf = suf.next;
        }
        now.next = pre;
        return now;
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = null;


        ReverseLinkedList_206 reverseLinkedList_206 = new ReverseLinkedList_206();
        ListNode head = reverseLinkedList_206.reverseList(l1);

        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
