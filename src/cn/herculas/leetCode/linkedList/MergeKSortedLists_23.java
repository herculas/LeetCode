package cn.herculas.leetCode.linkedList;

public class MergeKSortedLists_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        int size = lists.length;

        if (size == 0) {
            return null;
        }

        ListNode[] pointers = new ListNode[size];
        System.arraycopy(lists, 0, pointers, 0, size);

        ListNode merged = new ListNode(0);
        ListNode pointerMerged = merged;

        boolean[] nullChecker = new boolean[size];

        int nullCounter = 0;
        for (int i = 0; i < size; i++) {
            if (lists[i] == null) {
                nullChecker[i] = true;
                nullCounter++;
            } else {
                nullChecker[i] = false;
            }
        }

        while (nullCounter != size) {

            int min = Integer.MAX_VALUE;
            int index = Integer.MAX_VALUE;

            for (int i = 0; i < size; i++) {
                if (pointers[i] != null) {
                    if (pointers[i].val < min) {
                        min = pointers[i].val;
                        index = i;
                    }
                }
            }

            pointerMerged.next = new ListNode(min);
            pointerMerged = pointerMerged.next;
            pointers[index] = pointers[index].next;

            if (pointers[index] == null) {
                nullChecker[index] = true;
            }

            // 重新统计null指针个数
            nullCounter = 0;
            for (boolean nullFlag : nullChecker) {
                if (nullFlag) {
                    nullCounter++;
                }
            }
        }

        return merged.next;
    }

    public static void main(String[] args) {
        ListNode n11 = new ListNode(1);
        ListNode n12 = new ListNode(4);
        ListNode n13 = new ListNode(5);

        ListNode n21 = new ListNode(1);
        ListNode n22 = new ListNode(3);
        ListNode n23 = new ListNode(4);

        ListNode n31 = new ListNode(2);
        ListNode n32 = new ListNode(6);

        n11.next = n12;
        n12.next = n13;

        n21.next = n22;
        n22.next = n23;

        n31.next = n32;

        ListNode[] lists = {n11, n21, n31};
        MergeKSortedLists_23 mergeKSortedLists_23 = new MergeKSortedLists_23();
        ListNode temp = mergeKSortedLists_23.mergeKLists(lists);
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
