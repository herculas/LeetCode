package cn.herculas.leetCode.linkedList;

public class RotateList_61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        int count = 0;
        ListNode pointer = head;
        while (pointer != null) {
            count++;
            pointer = pointer.next;
        }

        int cut = k % count;
        if (cut == 0) {
            return head;
        } else {
            return this.singleRotate(head, count - cut);
        }
    }

    private ListNode singleRotate(ListNode head, int width) {
        ListNode iter = head;
        for (int i = 0; i < width - 1; i++) {
            iter = iter.next;
        }

        ListNode newHead = iter.next;
        iter.next = null;

        iter = newHead;
        while (iter.next != null) {
            iter = iter.next;
        }
        iter.next = head;

        return newHead;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        RotateList_61 rotateList_61 = new RotateList_61();
        ListNode res = rotateList_61.rotateRight(n1, 2);

        ListNode temp = res;
        while (temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
