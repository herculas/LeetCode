package cn.herculas.leetCode.linkedList;

public class CopyListWithRandomPointer_138 {
    public RandomListNode copyRandomList(RandomListNode head) {

        if (head == null) {
            return null;
        }

        RandomListNode newHead;
        RandomListNode pointer1;
        RandomListNode pointer2;
        pointer1 = head;

        while(pointer1 != null) {
            pointer2 = new RandomListNode(pointer1.label);
            pointer2.next = pointer1.next;
            pointer1.next = pointer2;
            pointer1 = pointer2.next;
        }

        newHead = head.next;

        for(pointer1 = head; pointer1 != null; pointer1 = pointer1.next.next) {
            if(pointer1.random != null)
                pointer1.next.random = pointer1.random.next;
        }

        for(pointer1 = head; pointer1 != null; pointer1 = pointer1.next) {
            pointer2 = pointer1.next;
            pointer1.next = pointer2.next;
            if (pointer2.next != null) {
                pointer2.next = pointer2.next.next;
            }
        }
        return newHead;
    }

    public static void main(String[] args) {
        RandomListNode r1 = new RandomListNode(-1);
        r1.next = null;
        r1.random = null;

        CopyListWithRandomPointer_138 copyListWithRandomPointer_138 = new CopyListWithRandomPointer_138();
        RandomListNode randomListNode = copyListWithRandomPointer_138.copyRandomList(r1);
    }
}
