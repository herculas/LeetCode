package cn.herculas.leetCode.design;

import java.util.ArrayList;
import java.util.List;

public class MinStack_155 {
    private int size;
    private List<Integer> list;
    private List<Integer> min;

    /** initialize your data structure here. */
    public MinStack_155() {
        this.list = new ArrayList<>();
        this.min = new ArrayList<>();
        this.size = 0;
    }

    public void push(int x) {
        this.list.add(this.size, x);

        if (this.size == 0) {
            this.min.add(this.size, x);
        } else {
            this.min.add(this.size, Math.min(x, this.min.get(this.size - 1)));
        }

        this.size += 1;
    }

    public void pop() {
        this.list.remove(size - 1);
        this.min.remove(size - 1);
        this.size -= 1;
    }

    public int top() {
        return this.list.get(size - 1);
    }

    public int getMin() {
        return this.min.get(size - 1);
    }

    public static void main(String[] args) {
        MinStack_155 obj = new MinStack_155();

        obj.push(-2);
        obj.push(0);
        obj.push(-1);
        obj.pop();

        int param_3 = obj.top();
        int param_4 = obj.getMin();
    }
}
