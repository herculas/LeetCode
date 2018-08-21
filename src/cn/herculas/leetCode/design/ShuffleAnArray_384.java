package cn.herculas.leetCode.design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffleAnArray_384 {
    private int[] set;

    private int[] dynamical;

    public ShuffleAnArray_384(int[] nums) {
        this.set = nums;
        this.dynamical = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.set;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        List<Integer> list = new ArrayList<Integer>();

        for (int aDynamical : this.dynamical) {
            list.add(aDynamical);
        }

        Collections.shuffle(list);

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] test = {1, 2, 3};

        ShuffleAnArray_384 shuffleAnArray_384 = new ShuffleAnArray_384(test);
        int[] param_1 = shuffleAnArray_384.reset();

        System.out.println("reset");
        for (int i = 0; i < param_1.length; i++) {
            System.out.print(param_1[i] + " ");
        }

        System.out.println();

        int[] param_2 = shuffleAnArray_384.shuffle();

        System.out.println("shuffle");
        for (int i = 0; i < param_2.length; i++) {
            System.out.print(param_2[i] + " ");
        }
    }
}
