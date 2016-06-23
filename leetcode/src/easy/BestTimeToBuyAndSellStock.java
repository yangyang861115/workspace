package easy;

/*
 * 121
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * Example:
 * Input: [7, 1, 5, 3, 6, 4]
 * Output: 5
 * max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
 * 
 * Input: [7, 6, 4, 3, 1]
 * Output: 0
 * In this case, no transaction is done, i.e. max profit = 0.
 *  */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        //solution 1
     // for(int i = 0; i < n - 1; i++) {
        // for(int j = i + 1; j < n; j++) {
        // if(prices[j]-prices[i] > maxprofit)
        // maxprofit = prices[j]-prices[i];
        // }
        // }
        
        
        //solution 2
        // int maxCur = 0;
        // int maxSofar = 0;
        // int n = prices.length;
        //
        //
        // for (int i = 1; i < n; i++) {
        // maxCur = Math.max(0, maxCur += prices[i] - prices[i - 1]);
        // maxSofar = Math.max(maxSofar, maxCur);
        // }
        // return maxSofar;
        
        //solution 3
        int n = prices.length;
        if(n <= 1) return 0;
        int min = prices[0];
        int p = 0;
        for(int i = 0; i < n; i++) {
            if(prices[i] < min) min = prices[i];
            else {
                if(prices[i] - min > p) p = prices[i] - min;
            }
        }
        return p;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int prices[] = new int[] { 7, 1, 5, 3, 6, 4 };
        BestTimeToBuyAndSellStock bt = new BestTimeToBuyAndSellStock();
        System.out.print(bt.maxProfit(prices));
    }

}
