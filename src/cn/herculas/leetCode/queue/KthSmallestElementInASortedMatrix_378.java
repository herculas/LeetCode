package cn.herculas.leetCode.queue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestElementInASortedMatrix_378 {
    public int kthSmallest(int[][] matrix, int k) {
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (queue.size() < k) {
                    queue.offer(matrix[i][j]);
                } else if (matrix[i][j] < queue.peek()) {
                    queue.poll();
                    queue.add(matrix[i][j]);
                }
            }
        }

        return queue.peek();
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };

        KthSmallestElementInASortedMatrix_378 kthSmallestElementInASortedMatrix_378 = new KthSmallestElementInASortedMatrix_378();
        System.out.println(kthSmallestElementInASortedMatrix_378.kthSmallest(matrix, 8));
    }
}
