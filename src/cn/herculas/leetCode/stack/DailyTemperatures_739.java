package cn.herculas.leetCode.stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures_739 {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();

        int size = T.length;
        int[] res = new int[size];

        if (size == 1)
            return res;

        stack.push(0);
        for (int i = 1; i < size; i++) {

            while (!stack.empty() && T[stack.peek()] < T[i]) {
                res[stack.peek()] = i - stack.peek();
                stack.pop();
            }

            stack.push(i);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] input = {73, 74, 75, 71, 69, 72, 76, 73};
        DailyTemperatures_739 dailyTemperatures_739 = new DailyTemperatures_739();
        System.out.println(Arrays.deepToString(new int[][]{dailyTemperatures_739.dailyTemperatures(input)}));
    }
}
