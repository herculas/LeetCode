package cn.herculas.leetCode.linkedList;

public class ReverseLinkedList_206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = head;
        ListNode pointer = head.next;

        while (pointer != null) {
            pointer.next = pre;
        }
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
