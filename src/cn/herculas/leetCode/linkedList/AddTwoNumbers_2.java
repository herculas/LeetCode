package cn.herculas.leetCode.linkedList;

public class AddTwoNumbers_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pointer1 = l1;
        ListNode pointer2 = l2;

        ListNode head = null;
        ListNode pointer = null;

        int co = 0;
        while (!(pointer1 == null && pointer2 == null)) {
            int currentValue = 0;
            if (pointer1 != null) {
                currentValue += pointer1.val;
                pointer1 = pointer1.next;
            }
            if (pointer2 != null) {
                currentValue += pointer2.val;
                pointer2 = pointer2.next;
            }
            currentValue += co;
            co = currentValue / 10;
            currentValue = currentValue % 10;

            ListNode current = new ListNode(currentValue);

            if (pointer == null) {
                head = current;
                pointer = current;
            } else {
                pointer.next = current;
                pointer = pointer.next;
            }
        }
        if (co != 0) {
            pointer.next = new ListNode(co);
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode n11 = new ListNode(2);
        ListNode n12 = new ListNode(4);
        ListNode n13 = new ListNode(3);

        ListNode n21 = new ListNode(5);
        ListNode n22 = new ListNode(6);
        ListNode n23 = new ListNode(4);

        n11.next = n12;
        n12.next = n13;

        n21.next = n22;
        n22.next = n23;

        AddTwoNumbers_2 addTwoNumbers_2 = new AddTwoNumbers_2();
        ListNode head = addTwoNumbers_2.addTwoNumbers(n11, n21);

        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
    }
}
