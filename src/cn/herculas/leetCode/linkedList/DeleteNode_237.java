package cn.herculas.leetCode.linkedList;

public class DeleteNode_237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(5);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(9);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = null;

        DeleteNode_237 deleteNode_237 = new DeleteNode_237();
        deleteNode_237.deleteNode(l3);
    }
}
