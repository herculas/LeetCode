package cn.herculas.leetCode.array;

import java.util.*;

/**
 *  借助一个辅助队列（双端队列），从头遍历数组，根据如下规则进行入队列或出队列操作：
 *  1. 如果队列为空，则当前数字入队列
 *  2. 如果当前数字大于队列尾，则删除队列尾，直到当前数字小于等于队列尾，或者队列空，然后当前数字入队列
 *  3. 如果当前数字小于队列尾，则当前数字入队列
 *  4. 如果队列头超出滑动窗口范围，则删除队列头
 *  这样能始终保证队列头为当前的最大值
 **/

public class SlidingWindowMaximum_239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> integerDeque = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();

        int size = nums.length;

        for (int i = 0; i < size; i++) {
            if (!integerDeque.isEmpty() && integerDeque.getFirst() == i - k) {
                integerDeque.pollFirst();
            }

            while (!integerDeque.isEmpty() && nums[integerDeque.getLast()] < nums[i]) {
                integerDeque.pollLast();
            }
            integerDeque.addLast(i);
            if (i >= k - 1) {
                res.add(nums[integerDeque.getFirst()]);
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] test = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] test2 = {7, 2, 4};
        SlidingWindowMaximum_239 slidingWindowMaximum_239 = new SlidingWindowMaximum_239();
        for (int num : slidingWindowMaximum_239.maxSlidingWindow(test2, 2)) {
            System.out.print(num + " ");
        }
    }
}
