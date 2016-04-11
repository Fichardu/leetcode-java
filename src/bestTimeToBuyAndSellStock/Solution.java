/*
 *Say you have an array for which the ith element is the price of a given stock on day i.
 *
 *If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 */
 public class Solution {
    public int maxProfit(int[] prices) {
        int minPro = Integer.MAX_VALUE;
        int maxPro = 0;
        for (int i=0; i<prices.length; ++i) {
            minPro = Math.min(minPro, prices[i]);
            maxPro = Math.max(maxPro, prices[i] - minPro);
        }
        return maxPro;
    }
}
