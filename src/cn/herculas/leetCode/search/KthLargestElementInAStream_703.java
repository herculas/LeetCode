package cn.herculas.leetCode.search;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAStream_703 {

    private Queue<Integer> queue;
    private int content;

    public KthLargestElementInAStream_703(int k, int[] nums) {
        this.queue = new PriorityQueue<>();
        this.content = k;

        for (int num : nums) {
            this.addOne(num);
        }
    }

    public int add(int val) {
        this.addOne(val);
        return this.queue.peek();
    }

    private void addOne(int val) {
        this.queue.add(val);
        if (this.queue.size() > this.content) {
            this.queue.poll();
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 8, 2};

        KthLargestElementInAStream_703 kthLargestElementInAStream_703 = new KthLargestElementInAStream_703(3, arr);

        System.out.println(kthLargestElementInAStream_703.add(3));
        System.out.println(kthLargestElementInAStream_703.add(5));
        System.out.println(kthLargestElementInAStream_703.add(10));
        System.out.println(kthLargestElementInAStream_703.add(9));
        System.out.println(kthLargestElementInAStream_703.add(4));
    }
}
