package cn.herculas.leetCode.graph;

import java.util.List;

public class FriendCircles_547 {
    public int findCircleNum(int[][] M) {
        if (M.length == 0 || M[0].length == 0) {
            return 0;
        }

        int[] pre = new int[M.length];

        for (int i = 0; i < M.length; i++) {
            pre[i] = i;
        }

        int count = M.length;

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (i != j && M[i][j] == 1) {
                    int x1 = this.find(i, pre);
                    int x2 = this.find(j, pre);

                    if (x1 != x2) {
                        pre[x1] = x2;
                        count--;
                    }
                }
            }
        }

        return count;
    }

    private int find(int x, int[] pre) {
        if (pre[x] == x) {
            return x;
        } else {
            return find(pre[x], pre);
        }
    }

    public static void main(String[] args) {
        int[][] M = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        FriendCircles_547 friendCircles_547 = new FriendCircles_547();
        System.out.println(friendCircles_547.findCircleNum(M));
    }
}
