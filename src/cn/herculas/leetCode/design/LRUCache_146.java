package cn.herculas.leetCode.design;

import java.util.HashMap;
import java.util.Queue;

class LRUCache_146 {

    private HashMap<Integer, Integer> cacheMap;
    private Queue<Integer>

    public LRUCache_146(int capacity) {

    }

    public int get(int key) {

    }

    public void put(int key, int value) {

    }

    public static void main(String[] args) {

        LRUCache_146 cache = new LRUCache_146(2);

        cache.put(1, 1);
        cache.put(2, 2);

        System.out.println(cache.get(1));       // returns 1

        cache.put(3, 3);                        // evicts key 2

        System.out.println(cache.get(2));       // returns -1 (not found)

        cache.put(4, 4);                        // evicts key 1

        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }
}
