package cn.herculas.leetCode.array;

import java.util.ArrayList;

public class ValidSudoku_36 {
    private final int SIZE = 9;
    public boolean isValidSudoku(char[][] board) {

        // TODO: 装配三个数组
        char[][] row = new char[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                row[i][j] = board[i][j];
            }
        }

        char[][] col = new char[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                col[i][j] = board[j][i];
            }
        }

        char[][] box = new char[SIZE][SIZE];


        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {

                if (i == 0 || i == 1 || i == 2) {

                    if (j == 0 || j == 1 || j == 2) {
                        box[0][3 * i + j] = board[i][j];
                    } else if (j == 3 || j == 4 || j == 5) {
                        box[1][3 * i + j - 3] = board[i][j];
                    }else {
                        box[2][3 * i + j - 6] = board[i][j];
                    }
                } else if (i == 3 || i == 4 || i == 5) {

                    if (j == 0 || j == 1 || j == 2) {
                        box[3][3 * i + j - 9] = board[i][j];
                    } else if (j == 3 || j == 4 || j == 5) {
                        box[4][3 * i + j - 12] = board[i][j];
                    }else {
                        box[5][3 * i + j - 15] = board[i][j];
                    }
                } else {

                    if (j == 0 || j == 1 || j == 2) {
                        box[6][3 * i + j - 18] = board[i][j];
                    } else if (j == 3 || j == 4 || j == 5) {
                        box[7][3 * i + j - 21] = board[i][j];
                    }else {
                        box[8][3 * i + j - 24] = board[i][j];
                    }
                }
            }
        }


        // TODO: 讨论三个数组内是否有重复元素
        return isValidRow(row) & isValidRow(col) & isValidRow(box);
    }

    private boolean isValidRow(char[][] test) {
        for (int i = 0; i < SIZE; i++) {

            ArrayList<Character> testArray = new ArrayList<>();

            for (int j = 0; j < SIZE; j++) {
                if (test[i][j] != '.') {
                    if (!testArray.contains(test[i][j])) {
                        testArray.add(test[i][j]);
                    } else {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ValidSudoku_36 validSudoku_36 = new ValidSudoku_36();

        char[][] test = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println(validSudoku_36.isValidSudoku(test));
    }
}
