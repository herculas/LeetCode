package cn.herculas.leetCode.linkedList;

public class DesignLinkedList_707 {

    private class Node {
        int val;
        Node next;

        Node(int value) {
            this.val = value;
            this.next = null;
        }
    }

    private Node head;
    /**
     * 构造器，初始化数据结构
     */
    public DesignLinkedList_707() {
    }

    /**
     * 获取链表中第 index 个结点的数据
     * 如果不存在该结点，返回 -1
     * @param index 需要获取的结点位置索引
     * @return 获取的结点的值
     */
    public int get(int index) {
        Node pointer = this.head;

        if (this.head == null) {
            return -1;
        }

        while (index != 0) {
            index--;
            if (pointer.next != null) {
                pointer = pointer.next;
            } else {
                return -1;
            }
        }

        return pointer.val;
    }

    /**
     * 在链表的首部添加值为 val 的新结点
     * 添加后，新结点为该链表的头
     * @param val 添加的结点值
     */
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = this.head;
        head = newNode;
    }

    /**
     * 在链表的尾部添加值为 val 的新结点
     * @param val 添加的结点值
     */
    public void addAtTail(int val) {
        Node pointer = this.head;

        if (this.head == null) {
            this.head = new Node(val);
            return;
        }

        while (pointer.next != null) {
            pointer = pointer.next;
        }
        pointer.next = new Node(val);
    }

    /**
     * 在链表的第 index 位置的结点之前添加值为 val 的新结点
     * 如果 index 的值等于链表的长度，该新结点将被缀于链表尾部
     * 如果 index 的值大于链表的长度，将不插入该新结点
     * @param index 添加的位置索引
     * @param val 添加的结点值
     */
    public void addAtIndex(int index, int val) {
        Node pointer = this.head;

        int len = 0;
        while (pointer != null) {
            len++;
            pointer = pointer.next;
        }

        pointer = this.head;

        if (index < len) {
            while (index != 1) {
                index--;
                pointer = pointer.next;
            }

            Node newNode = new Node(val);
            newNode.next = pointer.next;
            pointer.next = newNode;

        } else if (index == len) {
            this.addAtTail(val);
        }
    }

    /**
     * 在合法的前提下删除链表中第 index 位置的结点
     * @param index 要删除的结点的索引
     */
    public void deleteAtIndex(int index) {
        Node pointer = this.head;

        int len = 0;
        while (pointer != null) {
            len++;
            pointer = pointer.next;
        }

        pointer = this.head;

        if (index < len) {
            while (index != 1) {
                index--;
                pointer = pointer.next;
            }

            pointer.next = pointer.next.next;
        }
    }

    public static void main(String[] args) {

        DesignLinkedList_707 linkedList = new DesignLinkedList_707();

        System.out.println(linkedList.get(0));
        linkedList.addAtIndex(1, 2);
        System.out.println(linkedList.get(0));
        System.out.println(linkedList.get(1));
        linkedList.addAtIndex(0, 1);
        System.out.println(linkedList.get(0));
        System.out.println(linkedList.get(1));


        Node head = linkedList.head;
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
    }
}