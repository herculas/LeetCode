package cn.herculas.leetCode.dp;

public class CoinChange_322 {
    public int coinChange(int[] coins, int amount) {
        if (amount < 0 || coins.length == 0) {
            return -1;
        }
        int[] f = new int[amount + 1];
        f[0] = 0;

        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;

            for (int c : coins) {

                int j = i - c;
                if (j >= 0 && f[j] != -1) {
                    min = Math.min(min, f[j]);
                }

                f[i] = min == Integer.MAX_VALUE ? -1 : min + 1;
            }
        }
        return f[amount];
    }


    public static void main(String[] args) {
        int[] coins = {1, 3, 5};
        int amount = 11;

        int[] coins2 = {2};
        int amount2 = 3;

        CoinChange_322 coinChange_322 = new CoinChange_322();
        System.out.println(coinChange_322.coinChange(coins, amount));
        System.out.println(coinChange_322.coinChange(coins2, amount2));
    }
}
