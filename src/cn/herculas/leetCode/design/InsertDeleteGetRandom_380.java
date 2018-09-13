package cn.herculas.leetCode.design;

import java.util.*;

public class InsertDeleteGetRandom_380 {

    private Map<Integer, Integer> integerMap;
    private List<Integer> list;
    private int size;

    /** Initialize your data structure here. */
    public InsertDeleteGetRandom_380() {
        this.integerMap = new HashMap<>();
        this.list = new ArrayList<>();
        this.size = 0;
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (this.integerMap.containsKey(val)) {
            return false;
        } else {
            this.integerMap.put(val, size);
            this.size++;
            this.list.add(val);
            return true;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (this.integerMap.containsKey(val)) {
            int lastElementInList = this.list.get(this.size - 1);
            this.list.set(this.integerMap.get(val), lastElementInList);
            this.integerMap.put(lastElementInList, this.integerMap.get(val));

            this.integerMap.remove(val);
            this.list.remove(size - 1);
            this.size--;

            return true;
        } else {
            return false;
        }
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        return this.list.get(random.nextInt(size));
    }

    public static void main(String[] args) {
        InsertDeleteGetRandom_380 insertDeleteGetRandom_380 = new InsertDeleteGetRandom_380();
        boolean param1 = insertDeleteGetRandom_380.insert(1);
        boolean param2 = insertDeleteGetRandom_380.remove(2);
        int param3 = insertDeleteGetRandom_380.getRandom();

        System.out.println("param1: " + param1);
        System.out.println("param2: " + param2);
        System.out.println("param3: " + param3);
    }
}
