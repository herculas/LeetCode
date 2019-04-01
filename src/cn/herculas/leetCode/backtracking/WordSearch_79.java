package cn.herculas.leetCode.backtracking;

public class WordSearch_79 {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;

        boolean[][] visited = new boolean[row][col];

        boolean result = false;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0))
                    result = result || this.trace(board, visited, word, i, j, 0);
            }
        }
        return result;
    }

    private boolean trace(char[][] board, boolean[][] visited, String word, int x, int y, int index) {
        if (index >= word.length()) return true;
        if (x >= board.length || x < 0) return false;
        if (y >= board[0].length || y < 0) return false;
        if (visited[x][y]) return false;
        if (board[x][y] != word.charAt(index)) return false;

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        visited[x][y] = true;

        boolean result = false;
        for (int i = 0; i < 4; i++) {
            result = result || this.trace(board, visited, word, x + dx[i], y + dy[i], index + 1);
        }
        visited[x][y] = false;
        return result;
    }

    public static void main(String[] args) {
        char[][] testGrid =
        {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };

        String testString1 = "ABCCED";
        String testString2 = "SEE";
        String testString3 = "ABCB";

        WordSearch_79 wordSearch_79 = new WordSearch_79();
        System.out.println(wordSearch_79.exist(testGrid, testString1));
        System.out.println(wordSearch_79.exist(testGrid, testString2));
        System.out.println(wordSearch_79.exist(testGrid, testString3));
    }
}
