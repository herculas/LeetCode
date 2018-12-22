package cn.herculas.leetCode.linkedList;

public class RemoveNthNodeFromEnd_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        if (fast == null) {
            return slow.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);

        l1.next = null;


        RemoveNthNodeFromEnd_19 removeNthNodeFromEnd_19 = new RemoveNthNodeFromEnd_19();
        ListNode head = removeNthNodeFromEnd_19.removeNthFromEnd(l1, 1);

        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
