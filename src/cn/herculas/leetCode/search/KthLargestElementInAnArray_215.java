package cn.herculas.leetCode.search;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAnArray_215 {

    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
            if (queue.size() > k) queue.poll();
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        int[] test = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        KthLargestElementInAnArray_215 kthLargestElementInAnArray_215 = new KthLargestElementInAnArray_215();
        System.out.println(kthLargestElementInAnArray_215.findKthLargest(test, 4));
    }
}
