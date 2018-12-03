package cn.herculas.leetCode.queue;

public class CircularQueue_622 {

    private int capacity;
    private int size;

    private int[] queue;

    private int head;
    private int tail;

    /**
     * 构造器：构造大小为k的循环队列
     * @param k
     */
    public CircularQueue_622(int k) {
        this.capacity = k;
        this.queue = new int[this.capacity];
        this.size = 0;

        this.head = Integer.MAX_VALUE;
        this.tail = Integer.MAX_VALUE;
    }

    /**
     * 插入一个整型值value进入循环队列中
     * 操作成功后返回true
     * @param value
     * @return
     */
    public boolean enQueue(int value) {

        if (!this.isFull()) {

            if (this.isEmpty()) {

                this.size++;
                this.head = 0;

                this.tail = 0;
                this.queue[0] = value;
                return true;

            } else {

                this.size++;

                this.tail++;
                if (this.tail == this.capacity)
                    this.tail = 0;
                this.queue[this.tail] = value;

                return true;
            }
        } else
            return false;
    }

    /**
     * 从循环队列中删除队首元素
     * 操作成功后返回true
     * @return
     */
    public boolean deQueue() {

        if (!this.isEmpty()) {

            if (this.size == 1) {
                this.size--;

                this.head = Integer.MAX_VALUE;
                this.tail = Integer.MAX_VALUE;

                return true;
            } else {
                this.size--;

                this.head++;
                if (this.head == this.capacity)
                    this.head = 0;

                return true;
            }

        } else
            return false;
    }

    /**
     * 获得队首元素
     * 但不从队列中删除该元素
     * @return
     */
    public int Front() {
        if (this.isEmpty())
            return -1;
        else
            return this.queue[this.head];
    }

    /**
     * 获得队尾元素
     * 但不从队列中删除该元素
     * @return
     */
    public int Rear() {
        if (isEmpty())
            return -1;
        else
            return this.queue[this.tail];
    }

    /**
     * 检查循环队列是否为空
     * @return
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * 检查循环队列是否已满
     * @return
     */
    public boolean isFull() {
        return this.size == this.capacity;
    }


    public static void main(String[] args) {
        CircularQueue_622 obj = new CircularQueue_622(5);
        boolean param_1 = obj.enQueue(1);
        boolean param_2 = obj.deQueue();
        int param_3 = obj.Front();
        int param_4 = obj.Rear();
        boolean param_5 = obj.isEmpty();
        boolean param_6 = obj.isFull();
    }
}
