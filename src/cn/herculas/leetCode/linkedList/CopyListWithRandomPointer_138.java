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
        RandomListNode r1 = new RandomListNode(1);
        RandomListNode r2 = new RandomListNode(2);
        RandomListNode r3 = new RandomListNode(3);
        RandomListNode r4 = new RandomListNode(4);
        RandomListNode r5 = new RandomListNode(5);

        r1.next = r2;
        r2.next = r3;
        r3.next = r4;
        r4.next = r5;

        r1.random = r3;
        r2.random = r5;
        r3.random = null;
        r4.random = r2;
        r5.random = null;

        CopyListWithRandomPointer_138 copyListWithRandomPointer_138 = new CopyListWithRandomPointer_138();
        RandomListNode randomListNode = copyListWithRandomPointer_138.copyRandomList(r1);
    }
}
