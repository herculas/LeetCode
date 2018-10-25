package cn.herculas.leetCode.graph;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingPathInAMatrix_329 {
    public int longestIncreasingPath(int[][] matrix) {

        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int res = 1;
        int colSize = matrix.length;
        int rowSize = matrix[0].length;

        int[][] dp = new int[colSize][rowSize];

        for (int i = 0; i < colSize; i++) {
            for (int j = 0; j < rowSize; j++) {
                res = Math.max(res, this.dfs(matrix, dp, i, j));
            }
        }
        return res;
    }

    private int dfs(int[][] matrix, int[][] dp, int xIndex, int yIndex) {
        if (dp[xIndex][yIndex] != 0) {
            return dp[xIndex][yIndex];
        }

        int mx = 1;
        int colSize = matrix.length;
        int rowSize = matrix[0].length;

        int[][] directions = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

        for (int[] direction : directions) {
            int x = xIndex + direction[0];
            int y = yIndex + direction[1];

            if (x < 0 || x >= colSize || y < 0 || y >= rowSize || matrix[x][y] <= matrix[xIndex][yIndex]) {
                continue;
            }

            int length = 1 + dfs(matrix, dp, x, y);
            mx = Math.max(mx, length);
        }
        dp[xIndex][yIndex] = mx;
        return mx;
    }

    public static void main(String[] args) {
        int[][] matrix = {{3, 4, 5}, {3, 2, 6}, {2, 2, 1}};
        int[][] matrix2 = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};

        LongestIncreasingPathInAMatrix_329 longestIncreasingPathInAMatrix_329 = new LongestIncreasingPathInAMatrix_329();
        System.out.println(longestIncreasingPathInAMatrix_329.longestIncreasingPath(matrix));
        System.out.println(longestIncreasingPathInAMatrix_329.longestIncreasingPath(matrix2));
    }
}
