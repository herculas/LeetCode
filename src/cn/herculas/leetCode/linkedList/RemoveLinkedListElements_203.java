package cn.herculas.leetCode.linkedList;

public class RemoveLinkedListElements_203 {
    public ListNode removeElements(ListNode head, int val) {

        if (head == null) {
            return null;
        }

        while (head != null && head.val == val) {
            head = head.next;
        }

        ListNode pointer = head;

        while (pointer != null && pointer.next != null) {

            if (pointer.next.val == val) {
                if (pointer.next.next != null) {
                    pointer.next = pointer.next.next;
                } else {
                    pointer.next = null;
                }
            } else {
                pointer = pointer.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(6);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(5);
        ListNode n7 = new ListNode(6);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        RemoveLinkedListElements_203 removeLinkedListElements_203 = new RemoveLinkedListElements_203();
        ListNode res = removeLinkedListElements_203.removeElements(n1, 6);

        ListNode temp = res;
        while (temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
