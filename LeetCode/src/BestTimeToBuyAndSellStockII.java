/**
 * Created by yaodh on 2014/11/16.
 *
 * LeetCode: Best Time to Buy and Sell Stock II
 * Link: https://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * Description:
 * -----------------------------
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit.
 * You may complete as many transactions as you like
 * (ie, buy one and sell one share of the stock multiple times). However,
 * you may not engage in multiple transactions at the same time
 * (ie, you must sell the stock before you buy again).
 * -----------------------------
 *
 * Tag: Greedy
 */
public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int ans = 0;
        for(int i=1;i<prices.length;i++) {
            if(prices[i] < prices[i-1]) {
                continue;
            }
            int pre = prices[i-1];
            while(i<prices.length && prices[i] >= prices[i-1]) {
                i++;
            }
            ans += prices[i-1] - pre;
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans = new BestTimeToBuyAndSellStockII().maxProfit(new int[]{});
        System.out.println(ans);
    }
}
