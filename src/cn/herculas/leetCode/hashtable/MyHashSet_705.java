package cn.herculas.leetCode.hashtable;

public class MyHashSet_705 {

    private int M;
    private Node[] st;

    private static class Node {
        private int key;
        private Node next;

        Node(int key, Node next) {
            this.key = key;
            this.next = next;
        }
    }

    public MyHashSet_705() {
        this.M = 17;
        this.st = new Node[M];
    }

    private int hash(int key) {
        return (key & 0x7fffffff) % this.M;
    }

    public void add(int key) {
        int keyHash = this.hash(key);
        if (!this.contains(key)) {
            this.st[keyHash] = new Node(key, st[keyHash]);
        }
    }

    public void remove(int key) {
        int keyHash = this.hash(key);
        if (!this.contains(key))
            return;

        Node x = this.st[keyHash];
        boolean flag = false;

        if (x.key == key) {
            this.st[keyHash] = this.st[keyHash].next;
            return;
        }

        for (; x.next != null; x = x.next) {
            if (x.next.key == key) {
                flag = true;
                break;
            }
        }

        if (flag) {
            x.next = x.next.next;
        }
    }

    public boolean contains(int key) {
        int keyHash = this.hash(key);
        for (Node x = this.st[keyHash]; x != null; x = x.next) {
            if (key == x.key)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MyHashSet_705 hashSet = new MyHashSet_705();

        hashSet.add(9);
        hashSet.remove(19);
        hashSet.add(14);
        hashSet.remove(19);
        hashSet.remove(9);
        hashSet.add(0);
        hashSet.add(3);
        hashSet.add(4);
        hashSet.add(0);
        hashSet.remove(9);
    }
}
