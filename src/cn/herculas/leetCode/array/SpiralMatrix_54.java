package cn.herculas.leetCode.array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix_54 {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) return result;

        int upperBound = 0;
        int lowerBound = matrix.length - 1;
        int leftBound = 0;
        int rightBound = matrix[0].length - 1;

        while (true) {
            // 在上界线上，从左界运动至右界
            for (int col = leftBound; col <= rightBound ; col++) {
                result.add(matrix[upperBound][col]);
            }
            upperBound++;
            if (upperBound > lowerBound) {
                break;
            }

            // 在右界线上，从上界运动至下界
            for (int row = upperBound; row <= lowerBound; row++) {
                result.add(matrix[row][rightBound]);
            }

            rightBound--;
            if (rightBound < leftBound) {
                break;
            }

            // 在下界线上，从右界运动至左界
            for (int col = rightBound; col >= leftBound; col--) {
                result.add(matrix[lowerBound][col]);
            }

            lowerBound--;
            if (lowerBound < upperBound) {
                break;
            }

            // 在左界线上，从下界运动至上界
            for (int row = lowerBound; row >= upperBound; row--) {
                result.add(matrix[row][leftBound]);
            }

            leftBound++;
            if (leftBound > rightBound) {
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] test = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        SpiralMatrix_54 spiralMatrix_54 = new SpiralMatrix_54();
        System.out.println(spiralMatrix_54.spiralOrder(test));
    }
}
