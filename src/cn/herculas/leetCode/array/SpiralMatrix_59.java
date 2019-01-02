package cn.herculas.leetCode.array;

import java.util.Arrays;

public class SpiralMatrix_59 {
    public int[][] generateMatrix(int n) {

        if (n == 1) {
            return new int[][]{{1}};
        }

        int[][] res = new int[n][n];

        int direction = 1;
        int i = 0;
        int j = 0;
        int amount = 1;

        while (res[i][j] == 0) {
            res[i][j] = amount;
            amount++;

            switch (direction) {
                case 1:
                    if (j >= n - 1 || res[i][j + 1] != 0) {
                        direction = 2;
                        i++;
                    } else {
                        j++;
                    }
                    break;
                case 2:
                    if (i >= n - 1 || res[i + 1][j] != 0) {
                        direction = 3;
                        j--;
                    } else {
                        i++;
                    }
                    break;
                case 3:
                    if (j <= 0 || res[i][j - 1] != 0) {
                        direction = 4;
                        i--;
                    } else {
                        j--;
                    }
                    break;
                case 4:
                    if (i <= 0 || res[i - 1][j] != 0) {
                        direction = 1;
                        j++;
                    } else {
                        i--;
                    }
                    break;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int n = 1;
        SpiralMatrix_59 spiralMatrix_59 = new SpiralMatrix_59();
        System.out.println(Arrays.deepToString(spiralMatrix_59.generateMatrix(n)));
    }
}
