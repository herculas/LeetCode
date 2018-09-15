package cn.herculas.leetCode.array;

import java.util.Arrays;

public class GameOfLife_289 {
    public void gameOfLife(int[][] board) {

        int[][] result = new int[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) {
                    if (countRound(board, i, j) == 3) {
                        result[i][j] = 1;
                    }
                }

                if (board[i][j] == 1) {
                    if (countRound(board, i, j) < 2 || countRound(board, i, j) > 3) {
                        result[i][j] = 0;
                    } else if (countRound(board, i, j) == 2 || countRound(board, i, j) == 3) {
                        result[i][j] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            System.arraycopy(result[i], 0, board[i], 0, board[0].length);
        }
    }

    private int countRound(int[][] board, int x, int y) {
        int count = 0;

        if (x - 1 >= 0 && y - 1 >= 0 && board[x - 1][y - 1] == 1) {
            count++;
        }
        if (y - 1 >= 0 && board[x][y - 1] == 1) {
            count++;
        }
        if (x + 1 <= board.length - 1 && y - 1 >= 0 && board[x + 1][y - 1] == 1) {
            count++;
        }


        if (x - 1 >= 0 && board[x - 1][y] == 1) {
            count++;
        }
        if (x + 1 <= board.length - 1 && board[x + 1][y] == 1) {
            count++;
        }


        if (x - 1 >= 0 && y + 1 <= board[0].length - 1 && board[x - 1][y + 1] == 1) {
            count++;
        }
        if (y + 1 <= board[0].length - 1 && board[x][y + 1] == 1) {
            count++;
        }
        if (x + 1 <= board.length - 1 && y + 1 <= board[0].length - 1 && board[x + 1][y + 1] == 1) {
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] test = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        GameOfLife_289 gameOfLife_289 = new GameOfLife_289();
        gameOfLife_289.gameOfLife(test);
        System.out.println(Arrays.deepToString(test));
    }
}
