package cn.herculas.leetCode.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaxAreaOfIsland_695 {
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int maxArea = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    maxArea = Math.max(maxArea, this.bfs(grid, visited, i, j));
                }
            }
        }

        return maxArea;
    }

    private int bfs(int[][] grid, boolean[][] visited, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        int area = 0;
        int[] di = {0, -1, 0, 1};
        int[] dj = {-1, 0, 1, 0};

        visited[i][j] = true;
        area++;
        queue.add(new int[]{i, j});

        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            for (int adjPoint : this.adjcent(grid, top[0], top[1])) {
                int newI = top[0] + di[adjPoint];
                int newJ = top[1] + dj[adjPoint];

                if (!visited[newI][newJ]) {
                    queue.add(new int[]{newI, newJ});
                    visited[newI][newJ] = true;
                    area++;
                }
            }
        }
        return area;
    }

    /**
     * 0：左方
     * 1：上方
     * 2：右方
     * 3：下方
     */
    private Iterable<Integer> adjcent(int[][] grid, int i, int j) {
        List<Integer> adj = new ArrayList<>();
        int sizeRow = grid.length;
        int sizeCol = grid[0].length;

        if (j - 1 >= 0 && grid[i][j - 1] == 1) adj.add(0);
        if (i - 1 >= 0 && grid[i - 1][j] == 1) adj.add(1);
        if (j + 1 < sizeCol && grid[i][j + 1] == 1) adj.add(2);
        if (i + 1 < sizeRow && grid[i + 1][j] == 1) adj.add(3);

        return adj;
    }

    public static void main(String[] args) {
        int[][] island = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };

        MaxAreaOfIsland_695 maxAreaOfIsland_695 = new MaxAreaOfIsland_695();
        System.out.println(maxAreaOfIsland_695.maxAreaOfIsland(island));
    }
}
