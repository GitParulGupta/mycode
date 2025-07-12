package com.example.practice.code.arrays;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 * Example 1:
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * Example 2:
 *
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 */
public class BestTimeBuySellStock {

    public int solution1(int[] prices){
        if(prices.length==1){
            return 0;
        }

        int minPrice = prices[0];
        int maxProfit = 0;

        for(int i=1;i<prices.length;i++){
            int cost = prices[i]-minPrice;
            maxProfit = Math.max(cost,maxProfit);
            minPrice = Math.min(minPrice,prices[i]);
        }

        return maxProfit;
    }

    public int solution2(int[] prices){
        int profit=0;
        int maxProfit=0;

        int i=0; int j =1;
        while(j<prices.length){
            if(prices[i]>prices[j]){
                i = j;
            }else{
                profit = prices[j]-prices[i];
                maxProfit = Math.max(maxProfit,profit);
            }
            j++;
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        BestTimeBuySellStock obj = new BestTimeBuySellStock();
        System.out.println(obj.solution1(prices));
        System.out.println(obj.solution2(prices));
    }

}
