package cn.herculas.leetCode.linkedList;

public class RemoveNthNodeFromEnd_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode iterTemp = head;
        int count = 0;

        while (iterTemp != null) {
            iterTemp = iterTemp.next;
            count++;
        }

        // First Node
        if (n == count) {
            return head.next;
        }

        iterTemp = head;

        // Non-first Node
        for (int i = 0; i < count - n - 1; i++) {
            iterTemp = iterTemp.next;
        }
        iterTemp.next = iterTemp.next.next;
        return head;
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

        RemoveNthNodeFromEnd_19 removeNthNodeFromEnd_19 = new RemoveNthNodeFromEnd_19();
        ListNode head = removeNthNodeFromEnd_19.removeNthFromEnd(l1, 1);

        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
