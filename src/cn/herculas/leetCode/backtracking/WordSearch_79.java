package cn.herculas.leetCode.backtracking;

public class WordSearch_79 {
    int[] dh = {0, 1, 0, -1};
    int[] dw = {1, 0, -1, 0};

    public boolean exist(char[][] board, String word) {
        boolean[][] isVisited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                if (isThisWay(board, word, i, j, 0, isVisited))
                    return true;
        return false;
    }

    private boolean isThisWay(char[][] board, String word, int row, int column, int index, boolean[][] isVisited) {
        if (row < 0 ||
                row >= board.length ||
                column < 0 ||
                column >= board[0].length ||
                isVisited[row][column] ||
                board[row][column] != word.charAt(index)
                ) {
            return false;
        }

        if (++index == word.length()) {
            return true;
        }

        isVisited[row][column] = true;

        for (int i = 0; i < 4; i++) {
            if (isThisWay(board, word, row + dh[i], column + dw[i], index, isVisited)) {
                return true;
            }
        }

        isVisited[row][column] = false;
        return false;
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
        System.out.println(wordSearch_79.exist(testGrid, testString2));
    }
}
