package cn.herculas.leetCode.dp;

public class ClimbingStairs_70 {
    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int p1 = 1;
        int p2 = 2;

        int res = 0;
        for (int i = 2; i < n; i++) {
            res = p1 + p2;
            p1 = p2;
            p2 = res;
        }
        return res;
    }

    public static void main(String[] args) {
        int test = 4;
        ClimbingStairs_70 climbingStairs_70 = new ClimbingStairs_70();

        System.out.println(climbingStairs_70.climbStairs(test));
    }
}
