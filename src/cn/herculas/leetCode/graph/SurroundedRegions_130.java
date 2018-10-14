package cn.herculas.leetCode.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions_130 {
    public void solve(char[][] board) {

        if (board.length == 0 || board[0].length == 0) {
            return;
        }

        int colSize = board.length;
        int rowSize = board[0].length;

        boolean[][] marked = new boolean[colSize][rowSize];

        for (int i = 0; i < colSize; i++) {
            if (board[i][0] == 'O') {
                this.bfs(board, i, 0);
            }
            if (board[i][rowSize - 1] == 'O') {
                this.bfs(board, i, rowSize - 1);
            }
        }

        for (int i = 0; i < rowSize; i++) {
            if (board[0][i] == 'O') {
                this.bfs(board, 0, i);
            }
            if (board[colSize - 1][i] == 'O') {
                this.bfs(board, colSize - 1, i);
            }
        }

        for (int i = 0; i < colSize; i++) {
            for (int j = 0; j < rowSize; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void bfs(char[][] board, int x, int y) {

        int[][] adjArrays = {
                {0, 1},
                {0, -1},
                {1, 0},
                {-1, 0}
        };

        Queue<Integer[]> coordinates = new LinkedList<>();
        Integer[] thisCoordinate = {x, y};

        coordinates.offer(thisCoordinate);
        board[x][y] = '*';

        while (!coordinates.isEmpty()) {
            Integer[] popCoordinate = coordinates.poll();

            for (int i = 0; i < 4; i++) {
                int newX = popCoordinate[0] + adjArrays[i][0];
                int newY = popCoordinate[1] + adjArrays[i][1];

                if (
                        newX < 0 ||
                        newX >= board.length ||
                        newY < 0 ||
                        newY >= board[0].length
                ) {
                    continue;
                }

                if (board[newX][newY] == 'O') {
                    board[newX][newY] = '*';
                    coordinates.offer(new Integer[]{newX, newY});
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };

        SurroundedRegions_130 surroundedRegions_130 = new SurroundedRegions_130();
        surroundedRegions_130.solve(board);
        System.out.println(Arrays.deepToString(board));
    }
}
