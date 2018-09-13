package cn.herculas.leetCode.search;

public class SearchA2DMatrix_240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rowSize = matrix.length;
        int colSize = matrix[0].length;

        int rowIndex = 0;
        int colIndex = colSize - 1;

        while (rowIndex < rowSize && colIndex >= 0) {
            if (matrix[rowIndex][colIndex] > target) {
                colIndex--;
            } else if (matrix[rowIndex][colIndex] < target) {
                rowIndex++;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30},
                {21, 23, 25, 27, 32},
                {25, 27, 29, 31, 35}
        };

        int[][] matrix2 = {{1, 1}};

        int[][] matrix3 = {{4,6,9,10,15},{9,12,13,15,16}};

        SearchA2DMatrix_240 searchA2DMatrix_240 = new SearchA2DMatrix_240();
        System.out.println(searchA2DMatrix_240.searchMatrix(matrix, 14));
    }
}
