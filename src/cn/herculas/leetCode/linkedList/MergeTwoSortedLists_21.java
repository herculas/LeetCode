package cn.herculas.leetCode.linkedList;

public class MergeTwoSortedLists_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode pointer1 = l1;
        ListNode pointer2 = l2;

        ListNode merged = new ListNode(0);
        ListNode pointerMerged = merged;

        while (pointer1 != null || pointer2 != null) {

            if (pointer1 != null && pointer2 != null) {

                if (pointer1.val == pointer2.val) {

                    ListNode new1 = new ListNode(pointer1.val);
                    ListNode new2 = new ListNode(pointer2.val);
                    pointerMerged.next = new1;
                    pointerMerged = pointerMerged.next;
                    pointerMerged.next = new2;
                    pointerMerged = pointerMerged.next;
                    pointer1 = pointer1.next;
                    pointer2 = pointer2.next;


                } else if (pointer1.val < pointer2.val) {

                    pointerMerged.next = new ListNode(pointer1.val);
                    pointerMerged = pointerMerged.next;
                    pointer1 = pointer1.next;


                } else {

                    pointerMerged.next = new ListNode(pointer2.val);
                    pointerMerged = pointerMerged.next;
                    pointer2 = pointer2.next;
                }

            } else if (pointer1 == null) {
                pointerMerged.next = pointer2;
                pointer2 = null;

            } else {
                pointerMerged.next = pointer1;
                pointer1 = null;

            }
        }

        return merged.next;
    }

    public static void main(String[] args) {
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(4);

        ListNode l21 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l23 = new ListNode(4);

        l11.next = l12;
        l12.next = l13;
        l13.next = null;

        l21.next = l22;
        l22.next = l23;
        l23.next = null;

        MergeTwoSortedLists_21 mergeTwoSortedLists_21 = new MergeTwoSortedLists_21();
        ListNode temp = mergeTwoSortedLists_21.mergeTwoLists(l11, l21);
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
