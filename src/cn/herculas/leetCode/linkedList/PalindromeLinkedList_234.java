package cn.herculas.leetCode.linkedList;

public class PalindromeLinkedList_234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        ListNode copy = new ListNode(head.val);
        ListNode list = copy;
        ListNode p = head.next;

        while (p != null) {
            ListNode temp = new ListNode(p.val);
            list.next = temp;
            list = list.next;

            p = p.next;
        }

        ListNode reverse = reverseList(head);

        ListNode p1 = copy;
        ListNode p2 = reverse;

        while (p1 != null) {
            if (p1.val != p2.val) {
                return false;
            } else {
                p1 = p1.next;
                p2 = p2.next;
            }
        }

        return true;
    }

    private ListNode reverseList(ListNode head) {
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
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(1);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = null;

        PalindromeLinkedList_234 palindromeLinkedList_234 = new PalindromeLinkedList_234();
        System.out.println(palindromeLinkedList_234.isPalindrome(l1));

    }
}
