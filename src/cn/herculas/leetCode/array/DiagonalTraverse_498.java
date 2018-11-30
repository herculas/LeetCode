package cn.herculas.leetCode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiagonalTraverse_498 {
    public int[] findDiagonalOrder(int[][] matrix) {

        if (matrix.length == 0 || matrix[0].length == 0)
            return new int[0];

        int sizeCol = matrix.length;
        int sizeRow = matrix[0].length;

        int i = 0;
        int j = 0;

        boolean direction = false;

        List<Integer> res = new ArrayList<>();

        while (i < sizeCol - 1 || j < sizeRow - 1) {

            res.add(matrix[i][j]);

            if (!direction) {
                if (j < sizeRow - 1 && i == 0) {
                    j++;
                    direction = true;
                    continue;
                }
                if (j == sizeRow - 1) {
                    i++;
                    direction = true;
                    continue;
                }
                i--;
                j++;
            }

            if (direction) {
                if (i < sizeCol - 1 && j == 0) {
                    i++;
                    direction = false;
                    continue;
                }
                if (i == sizeCol - 1) {
                    j++;
                    direction = false;
                    continue;
                }
                i++;
                j--;
            }
        }
        res.add(matrix[sizeCol - 1][sizeRow - 1]);
        return res.stream().mapToInt(k -> k).toArray();
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}
        };

        DiagonalTraverse_498 diagonalTraverse_498 = new DiagonalTraverse_498();
        System.out.println(Arrays.deepToString(new int[][]{diagonalTraverse_498.findDiagonalOrder(matrix)}));
    }
}
