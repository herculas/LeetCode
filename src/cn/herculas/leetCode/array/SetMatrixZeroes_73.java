package cn.herculas.leetCode.array;

import java.util.ArrayList;
import java.util.List;

public class SetMatrixZeroes_73 {
    public void setZeroes(int[][] matrix) {
        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();

        int sizeRow = matrix.length;

        if (sizeRow == 0) {
            return;
        }

        int sizeCol = matrix[0].length;

        int count = 0;
        for (int i = 0; i < sizeRow; i++) {
            for (int j = 0; j < sizeCol; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                    count++;
                }
            }
        }

        for (int i = 0; i < count; i++) {
            setRowToZeros(row.get(i), matrix, sizeCol);
            setColToZeros(col.get(i), matrix, sizeRow);
        }
    }

    private void setRowToZeros(int row, int[][] matrix, int sizeY) {
        for (int i = 0; i < sizeY; i++) matrix[row][i] = 0;
    }

    private void setColToZeros(int col, int[][] matrix, int sizeX) {
        for (int i = 0; i < sizeX; i++) matrix[i][col] = 0;
    }

    public static void main(String[] args) {
        int[][] test1 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] test2 = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};

        SetMatrixZeroes_73 setMatrixZeroes_73 = new SetMatrixZeroes_73();
        setMatrixZeroes_73.setZeroes(test1);
        setMatrixZeroes_73.setZeroes(test2);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(test1[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(test2[i][j] + " ");
            }
            System.out.println();
        }
    }
}
