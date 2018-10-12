package cn.herculas.leetCode.linkedList;

public class SortList_148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;

        ListNode pre = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }

        if (pre != null) {
            pre.next = null;
        }

        ListNode node1 = sortList(head);
        ListNode node2 = sortList(slow);

        return merge(node1, node2);
    }

    private ListNode merge(ListNode node1, ListNode node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }

        ListNode beforeHead = new ListNode(-1);
        ListNode index = beforeHead;

        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                index.next = node1;
                node1 = node1.next;
                index = index.next;
            } else {
                index.next = node2;
                node2 = node2.next;
                index = index.next;
            }
        }

        if (node1 != null) {
            index.next = node1;
        }
        if (node2 != null) {
            index.next = node2;
        }

        return beforeHead.next;
    }

    public static void main(String[] args) {
        ListNode n11 = new ListNode(4);
        ListNode n12 = new ListNode(2);
        ListNode n13 = new ListNode(1);
        ListNode n14 = new ListNode(3);

        ListNode n21 = new ListNode(-1);
        ListNode n22 = new ListNode(5);
        ListNode n23 = new ListNode(3);
        ListNode n24 = new ListNode(4);
        ListNode n25 = new ListNode(0);

        n11.next = n12;
        n12.next = n13;
        n13.next = n14;
        n14.next = null;

        n21.next = n22;
        n22.next = n23;
        n23.next = n24;
        n24.next = n25;
        n25.next = null;

        SortList_148 sortList_148 = new SortList_148();
        ListNode sortedList1 = sortList_148.sortList(n11);
        ListNode sortedList2 = sortList_148.sortList(n21);

        ListNode temp = sortedList1;
        while (temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println("null");

        temp = sortedList2;
        while (temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
