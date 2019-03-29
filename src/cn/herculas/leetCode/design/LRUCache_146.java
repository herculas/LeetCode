package cn.herculas.leetCode.design;

import java.util.LinkedHashMap;
import java.util.Map;


class LRUCache_146 {

    private int capacity;
    private Map<Integer, Integer> map;

    public LRUCache_146(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<>();
    }

    public int get(int key) {
        if (this.map.containsKey(key)) {
            int value = map.get(key);
            map.remove(key);
            map.put(key, value);
            return value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (this.map.containsKey(key)) {
            map.remove(key);
        }
        if (map.size() >= capacity) {
            map.remove(map.keySet().iterator().next());
        }
        map.put(key, value);
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
