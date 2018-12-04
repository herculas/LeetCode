package cn.herculas.leetCode.graph;

import java.util.*;

public class FloodFill_733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        Queue<int[]> ints = new LinkedList<>();
        boolean[][] visited = new boolean[image.length][image[0].length];


        int startColor = image[sr][sc];

        ints.add(new int[]{sr, sc});
        visited[sr][sc] = true;
        image[sr][sc] = newColor;

        while (!ints.isEmpty()) {
            int size = ints.size();
            for (int i = 0; i < size; i++) {
                int[] current = ints.peek();
                assert current != null;
                for (int[] coordinate : this.adj(image, current[0], current[1], newColor, startColor, visited)) {
                    image[coordinate[0]][coordinate[1]] = newColor;
                    ints.add(new int[]{coordinate[0], coordinate[1]});
                    visited[coordinate[0]][coordinate[1]] = true;
                }
                ints.poll();
            }
        }
        return image;
    }

    private Iterable<int[]> adj(int[][] image, int cr, int cc, int newColor, int startColor, boolean[][] visited) {
        Set<int[]> adjs = new HashSet<>();
        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int newRow = cr + dr[i];
            int newCol = cc + dc[i];

            if (newRow < 0 || newRow >= image.length || newCol < 0 || newCol >= image[0].length)
                continue;
            if (visited[newRow][newCol])
                continue;
            if (image[newRow][newCol] != startColor)
                continue;

            adjs.add(new int[]{newRow, newCol});
        }
        return adjs;
    }

    public static void main(String[] args) {
        int[][] image = {
                {0, 0, 0},
                {0, 1, 1}
        };
        int sr = 1;
        int sc = 1;
        int newColor = 1;

        FloodFill_733 floodFill_733 = new FloodFill_733();
        System.out.println(Arrays.deepToString(floodFill_733.floodFill(image, sr, sc, newColor)));
    }
}
