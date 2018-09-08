package cn.herculas.leetCode.graph;

public class NumberOfIslands_200 {
    public int numIslands(char[][] grid) {
        int size1 = grid.length;
        if (size1 == 0) {
            return 0;
        }
        int size2 = grid[0].length;
        int count = 0;

        boolean[][] marked = new boolean[size1][size2];
        for (int i = 0; i < size1; i++) {
            for (int j = 0; j < size2; j++) {
                if (!marked[i][j] && grid[i][j] == '1') {
                    dfs(grid, marked, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, boolean[][] marked, int row, int col) {

        marked[row][col] = true;

        if (row != 0 && !marked[row - 1][col] && grid[row - 1][col] == '1') {
            dfs(grid, marked, row - 1, col);
        }

        if (col != 0 && !marked[row][col - 1] && grid[row][col - 1] == '1') {
            dfs(grid, marked, row, col - 1);
        }

        if (row != grid.length - 1 && !marked[row + 1][col] && grid[row + 1][col] == '1') {
            dfs(grid, marked, row + 1, col);
        }

        if (col != grid[0].length - 1 && !marked[row][col + 1] && grid[row][col + 1] == '1') {
            dfs(grid, marked, row, col + 1);
        }
    }

    public static void main(String[] args) {
        char[][] grid =
                {
                        {'1', '1', '0', '0', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '1', '0', '0'},
                        {'0', '0', '0', '1', '1'}
                };

        NumberOfIslands_200 numberOfIslands_200 = new NumberOfIslands_200();
        System.out.println(numberOfIslands_200.numIslands(grid));
    }
}
