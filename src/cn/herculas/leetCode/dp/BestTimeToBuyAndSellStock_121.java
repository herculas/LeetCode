package cn.herculas.leetCode.dp;

public class BestTimeToBuyAndSellStock_121 {
    public int maxProfit(int[] prices) {
        int res = 0;
        int min = Integer.MAX_VALUE;

        for (int num : prices) {
            min = Math.min(min, num);
            res = Math.max(res, num - min);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] test = {7, 1, 5, 3, 6, 4};
        BestTimeToBuyAndSellStock_121 bestTimeToBuyAndSellStock_121 = new BestTimeToBuyAndSellStock_121();

        System.out.println(bestTimeToBuyAndSellStock_121.maxProfit(test));
    }
}
