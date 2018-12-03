package cn.herculas.leetCode.queue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class PerfectSquares_279 {
    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        int step = 0;
        queue.offer(n);
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                if (!set.add(curr)) {
                    continue;
                }
                for (int j = 1; j <= Math.sqrt(curr); j++) {
                    int next = curr - j * j;
                    if (next == 0) {
                        return step;
                    }
                    queue.offer(next);
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        PerfectSquares_279 perfectSquares_279 = new PerfectSquares_279();
        System.out.println(perfectSquares_279.numSquares(12));
    }
}
