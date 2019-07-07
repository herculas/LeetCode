package cn.herculas.leetCode.array;

public class SetMatrixZeroes_73 {
    public void setZeroes(int[][] matrix) {
        int[] indexRow = new int[matrix.length];
        int[] indexCol = new int[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    indexRow[i] = 1;
                    indexCol[j] = 1;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (indexRow[i] == 1 || indexCol[j] == 1)
                    matrix[i][j] = 0;
            }
        }
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
