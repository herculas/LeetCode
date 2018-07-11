package cn.herculas.leetCode.array;

public class RotateImage_48 {
    public void rotate(int[][] matrix) {

        int size = matrix.length;

        for (int i = 0; i < size / 2; i++) {
            for (int j = 0; j < size - 1 - 2 * i; j++) {
                int temp = matrix[i][i + j];
                matrix[i][i + j] = matrix[size - i - j - 1][i];
                matrix[size - i - j - 1][i] = matrix[size - i - 1][size - i - j - 1];
                matrix[size - i - 1][size - i - j - 1] = matrix[i + j][size - i - 1];
                matrix[i + j][size - i - 1] = temp;
            }
        }
    }

    public static void main(String[] args) {

        int[][] test = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };

        RotateImage_48 rotateImage_48 = new RotateImage_48();
        rotateImage_48.rotate(test);

        int size = test.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(test[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
