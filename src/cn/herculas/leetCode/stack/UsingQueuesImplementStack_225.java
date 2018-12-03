package cn.herculas.leetCode.stack;

import java.util.LinkedList;
import java.util.Queue;

public class UsingQueuesImplementStack_225 {

    private Queue<Integer> queue;
    private int size;

    public UsingQueuesImplementStack_225() {
        this.queue = new LinkedList<>();
        this.size = 0;
    }

    /**
     * 将元素x入栈
     * @param x
     */
    public void push(int x) {
        this.queue.add(x);
        this.size++;
    }

    /**
     * 移除栈顶元素
     * @return
     */
    public int pop() {
        Queue<Integer> tempQueue = new LinkedList<>();
        for (int i = 0; i < size - 1; i++) {
            tempQueue.add(this.queue.poll());
        }
        int pop = this.queue.poll();
        this.queue = tempQueue;
        this.size--;
        return pop;
    }

    /**
     * 获取栈顶元素
     * 但不移除
     * @return
     */
    public int top() {
        Queue<Integer> tempQueue = new LinkedList<>();
        for (int i = 0; i < size - 1; i++) {
            tempQueue.add(this.queue.poll());
        }
        int top = this.queue.poll();
        tempQueue.add(top);
        this.queue = tempQueue;
        return top;
    }

    /**
     * 判断栈是否为空
     * @return
     */
    public boolean empty() {
        return this.size == 0;
    }

    public static void main(String[] args) {
        UsingQueuesImplementStack_225 obj = new UsingQueuesImplementStack_225();
        obj.push(1);
        obj.push(2);
        int param_2 = obj.pop();
        int param_3 = obj.top();
        boolean param_4 = obj.empty();
    }
}
