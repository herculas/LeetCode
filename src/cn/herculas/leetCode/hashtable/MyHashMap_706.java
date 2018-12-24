package cn.herculas.leetCode.hashtable;

public class MyHashMap_706 {

    private int M;
    private Node[] st;

    private static class Node {
        private int key;
        private int value;
        private Node next;

        public Node(int key, int value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public MyHashMap_706() {
        this.M = 17;
        this.st = new Node[M];
    }

    private int hash(int key) {
        return (key & 0x7fffffff) % this.M;
    }

    public void put(int key, int value) {
        int i = this.hash(key);
        for (Node x = st[i]; x != null; x = x.next)
            if (key == x.key) {
                x.value = value;
                return;
            }

        st[i] = new Node(key, value, st[i]);
    }

    public int get(int key) {
        int i = this.hash(key);
        for (Node x = st[i]; x != null; x = x.next)
            if (key == x.key)
                return x.value;
        return -1;
    }

    public void remove(int key) {
        int keyHash = this.hash(key);
        if (this.get(key) == -1)
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

    public static void main(String[] args) {
        MyHashMap_706 hashMap = new MyHashMap_706();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        hashMap.get(1);            // 返回 1
        hashMap.get(3);            // 返回 -1 (未找到)
        hashMap.put(2, 1);         // 更新已有的值
        hashMap.get(2);            // 返回 1
        hashMap.remove(2);         // 删除键为2的数据
        hashMap.get(2);            // 返回 -1 (未找到)
    }
}
