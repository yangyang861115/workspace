package medium;
/*
 * 122 Best Time to Buy and Sell Stock II
 * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time 
(ie, you must sell the stock before you buy again).
 * */
public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int n = prices.length;
        if(n <= 1) return profit;
        
        int i = -1, j = -1;
        int buyPrice = Integer.MAX_VALUE;
        int sellPrice = Integer.MIN_VALUE;
        for(int k = 0; k < n; k++) {
            if(prices[k] < buyPrice) {
                buyPrice = prices[k];
                i = k;
            }
            
            if (prices[k] >= sellPrice) {
                sellPrice = prices[k];
                j = k;
            }
            
            if(i < j) {
                profit += (sellPrice - buyPrice);
                buyPrice = sellPrice;
                sellPrice = Integer.MIN_VALUE;
                i = j;
            }else if(i > j) {
                j = i;
                sellPrice = prices[i];
            }
            
        }
        
        return profit;
    }
    
    //simple way
    public int maxProfit2(int[] prices) {
        int profit = 0;
        int n = prices.length;
        if(n <= 1) return profit;
        
        for(int i = 1; i < n; i++) {
            if(prices[i] > prices[i - 1]){
                profit += (prices[i] - prices[i - 1]);
            }
        }
        return profit;
    }
}
