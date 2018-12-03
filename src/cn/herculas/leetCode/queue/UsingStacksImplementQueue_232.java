package cn.herculas.leetCode.queue;

import java.util.Stack;

public class UsingStacksImplementQueue_232 {

    private Stack<Integer> stack;
    private int size;

    public UsingStacksImplementQueue_232() {
        this.stack = new Stack<>();
        this.size = 0;
    }

    /**
     * 将一个元素放入队列的尾部
     * @param x
     */
    public void push(int x) {
        this.stack.push(x);
        this.size++;
    }

    /**
     * 从队列首部移除元素
     * @return
     */
    public int pop() {
        int[] temp = new int[this.size - 1];
        for (int i = temp.length - 1; i >= 0; i--) {
            temp[i] = this.stack.pop();
        }
        int pop = this.stack.pop();
        for (int i = 0; i < temp.length; i++) {
            this.stack.push(temp[i]);
        }
        this.size--;
        return pop;
    }

    /**
     * 返回队列首部的元素
     * 但不从队列中删除
     * @return
     */
    public int peek() {
        int[] temp = new int[this.size];
        for (int i = temp.length - 1; i >= 0; i--) {
            temp[i] = this.stack.pop();
        }

        for (int i = 0; i < temp.length; i++) {
            this.stack.push(temp[i]);
        }
        return temp[0];
    }

    /**
     * 判断队列是否为空
     * @return
     */
    public boolean empty() {
        return this.size == 0;
    }
}
