package cn.herculas.leetCode.queue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindMedianFromDataStream_295 {

    private Queue<Integer> lowQueue;
    private Queue<Integer> highQueue;

    private int lowCount;
    private int highCount;

    public FindMedianFromDataStream_295() {
        this.lowQueue = new PriorityQueue<>(Collections.reverseOrder());
        this.highQueue = new PriorityQueue<>();
        this.lowCount = 0;
        this.highCount = 0;
    }

    public void addNum(int num) {
        if (num <= this.findMedian()) {
            this.lowQueue.offer(num);
            this.lowCount++;
        } else {
            this.highQueue.offer(num);
            this.highCount++;
        }

        if (this.lowCount < this.highCount) {
            this.lowQueue.offer(this.highQueue.poll());
            this.lowCount++;
            this.highCount--;
        } else if (this.lowCount > this.highCount + 1) {
            this.highQueue.offer(this.lowQueue.poll());
            this.highCount++;
            this.lowCount--;
        }
    }

    public double findMedian() {
        if (this.lowCount == 0 && this.highCount == 0)
            return 0;

        if (this.lowCount == this.highCount) {
            return (this.lowQueue.peek() + this.highQueue.peek()) / 2.0;
        } else {
            return this.lowQueue.peek();
        }
    }

    public static void main(String[] args) {
        FindMedianFromDataStream_295 object = new FindMedianFromDataStream_295();

        object.addNum(1);
        object.addNum(2);

        System.out.println(object.findMedian());

        object.addNum(3);

        System.out.println(object.findMedian());
    }
}
