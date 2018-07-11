package cn.herculas.leetCode.array;

public class BestTimeToBuyAndSellStock_122 {
    public int maxProfit(int[] prices) {
        int sum = 0;
        int size = prices.length;

        for (int i = 1; i < size; i++) {
           if (prices[i - 1] < prices[i]) {
               sum += prices[i] - prices[i - 1];
           }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] p = {7, 6, 4, 3, 1};

        BestTimeToBuyAndSellStock_122 bestTimeToBuyAndSellStock_122 = new BestTimeToBuyAndSellStock_122();

        System.out.println(bestTimeToBuyAndSellStock_122.maxProfit(p));

    }
}
