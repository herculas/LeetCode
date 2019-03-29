package cn.herculas.leetCode.linkedList;

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node(int val, Node prev, Node next, Node child) {
        this.val = val;
        this.prev = prev;
        this.next = next;
        this.child = child;
    }
}

public class FlattenAMultilevelDoublyLinkedList_430 {
    public Node flatten(Node head) {
        flattentail(head);
        return head;
    }

    private Node flattentail(Node head) {
        if (head == null)
            return null;

        if (head.child == null) {
            if (head.next == null)
                return head;
            return flattentail(head.next);
        } else {
            Node child = head.child;
            Node next = head.next;
            head.next = child;
            child.prev = head;
            head.child = null;
            Node childtail = flattentail(child);
            if (next != null){
                childtail.next = next;
                next.prev = childtail;
                return flattentail(next);
            }
            return childtail;
        }
    }

    public static void main(String[] args) {
        Node n11 = new Node(1, null, null, null);
        Node n12 = new Node(2, n11, null, null);
        Node n13 = new Node(3, n12, null, null);
        Node n14 = new Node(4, n13, null, null);
        Node n15 = new Node(5, n14, null, null);
        Node n16 = new Node(6, n15, null, null);

        Node n21 = new Node(7, null, null, null);
        Node n22 = new Node(8, n21, null, null);
        Node n23 = new Node(9, n22, null, null);
        Node n24 = new Node(10, n23, null, null);

        Node n31 = new Node(11, null, null, null);
        Node n32 = new Node(12, n31, null, null);

        n11.next = n12;
        n12.next = n13;
        n13.next = n14;
        n14.next = n15;
        n15.next = n16;

        n21.next = n22;
        n22.next = n23;
        n23.next = n24;

        n31.next = n32;

        n13.child = n21;
        n22.child = n31;

        FlattenAMultilevelDoublyLinkedList_430 flattenAMultilevelDoublyLinkedList_430 = new FlattenAMultilevelDoublyLinkedList_430();
        Node res = flattenAMultilevelDoublyLinkedList_430.flatten(n11);

        Node temp = res;
        while (temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
