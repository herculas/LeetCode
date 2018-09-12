package cn.herculas.leetCode.search;

public class SearchA2DMatrix_240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        return true;
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
        System.out.println(searchA2DMatrix_240.searchMatrix(matrix3, 14));
    }
}
