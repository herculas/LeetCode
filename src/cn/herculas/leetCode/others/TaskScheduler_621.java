package cn.herculas.leetCode.others;

import java.util.Arrays;

public class TaskScheduler_621 {
    public int leastInterval(char[] tasks, int n) {
        int[] c = new int[26];

        for (char t : tasks){
            c[t - 'A']++;
        }
        Arrays.sort(c);

        int i = 25;
        while (i >= 0 && c[i] == c[25]) i--;

        return Math.max(tasks.length, (c[25]-1) * (n+1) + (25-i));
    }

    public static void main(String[] args) {
        char[] task = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;

        TaskScheduler_621 taskScheduler_621 = new TaskScheduler_621();
        System.out.println(taskScheduler_621.leastInterval(task, n));
    }
}
