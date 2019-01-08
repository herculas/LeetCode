package cn.herculas.leetCode.design;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Bucket {
    public int value;
    Set<String> keys;
    Bucket pre;
    public Bucket next;

    Bucket(int value) {
        this.value = value;
        this.keys = new HashSet<>();
    }
}

public class AllOOneDataStructure_432 {

    private Bucket head;
    private Bucket tail;
    private Map<String, Integer> keyValueMap;
    private Map<Integer, Bucket> valueBucketMap;

    public AllOOneDataStructure_432() {
        this.head = new Bucket(Integer.MIN_VALUE);
        this.tail = new Bucket(Integer.MAX_VALUE);

        this.head.next = this.tail;
        this.tail.pre = this.head;

        this.keyValueMap = new HashMap<>();
        this.valueBucketMap = new HashMap<>();
    }

    private void changeValue(String key, int increase) {
        int value = this.keyValueMap.get(key);
        this.keyValueMap.put(key, value + increase);

        Bucket currentBucket = this.valueBucketMap.get(value);
        Bucket newBucket;

        if (this.valueBucketMap.containsKey(value + increase)) {
            newBucket = this.valueBucketMap.get(value + increase);
        } else {
            newBucket = new Bucket(value + increase);
            this.valueBucketMap.put(value + increase, newBucket);
            this.insertBucket(newBucket, increase == 1 ? currentBucket : currentBucket.pre);
        }
        newBucket.keys.add(key);
        this.removeNodeFromBucket(currentBucket, key);
    }

    private void removeNodeFromBucket(Bucket bucket, String key) {
        bucket.keys.remove(key);
        if (bucket.keys.isEmpty()) {
            removeBucket(bucket);
            this.valueBucketMap.remove(bucket.value);
        }
    }

    private void removeBucket(Bucket bucket) {
        bucket.pre.next = bucket.next;
        bucket.next.pre = bucket.pre;

        bucket.pre = null;
        bucket.next = null;
    }

    private void insertBucket(Bucket newBucket, Bucket preBucket) {
        newBucket.next = preBucket.next;
        newBucket.pre = preBucket;

        preBucket.next.pre = newBucket;
        preBucket.next = newBucket;
    }

    public void inc(String key) {
        if (this.keyValueMap.containsKey(key)) {
            this.changeValue(key, 1);
        } else {
            keyValueMap.put(key, 1);
            if (this.head.next.value != 1) insertBucket(new Bucket(1), this.head);
            this.head.next.keys.add(key);
            this.valueBucketMap.put(1, this.head.next);
        }
    }

    public void dec(String key) {
        if (this.keyValueMap.containsKey(key)) {
            int value = this.keyValueMap.get(key);
            if (value == 1) {
                this.keyValueMap.remove(key);
                removeNodeFromBucket(this.valueBucketMap.get(value), key);
            } else {
                changeValue(key, -1);
            }
        }
    }

    public String getMaxKey() {
        if (this.tail.pre == this.head) return "";
        else return this.tail.pre.keys.iterator().next();
    }

    public String getMinKey() {
        if (this.head.next == this.tail) return "";
        else return this.head.next.keys.iterator().next();
    }

    public static void main(String[] args) {

    }
}
