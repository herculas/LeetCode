package cn.herculas.leetCode.graph;

import java.util.*;

public class Matrix01_542 {
    public int[][] updateMatrix(int[][] matrix) {

        int[][] result = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0)
                    result[i][j] = 0;
                else
                    result[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (result[i][j] != 0) {
                    if (this.miniAdj(result, i, j) != Integer.MAX_VALUE)
                        result[i][j] = this.miniAdj(result, i, j) + 1;
                }
            }
        }

        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[0].length - 1; j >= 0; j--) {
                if (result[i][j] != 0) {
                    if (this.miniAdj(result, i, j) != Integer.MAX_VALUE)
                        result[i][j] = this.miniAdj(result, i, j) + 1;
                }
            }
        }

        return result;
    }

    private int miniAdj(int[][] result, int row, int col) {
        int minimum = Integer.MAX_VALUE;

        if (row - 1 >= 0)
            minimum = Math.min(minimum, result[row - 1][col]);
        if (row + 1 < result.length)
            minimum = Math.min(minimum, result[row + 1][col]);
        if (col - 1 >= 0)
            minimum = Math.min(minimum, result[row][col - 1]);
        if (col + 1 < result[0].length)
            minimum = Math.min(minimum, result[row][col + 1]);

        return minimum;
    }

    public static void main(String[] args) {
        int[][] matrix = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        Matrix01_542 matrix01_542 = new Matrix01_542();
        System.out.println(Arrays.deepToString(matrix01_542.updateMatrix(matrix)));
    }
}
