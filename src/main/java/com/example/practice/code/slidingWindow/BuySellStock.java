package com.example.practice.code.slidingWindow;

/**
 * You are given an integer array prices where prices[i] is the price of NeetCoin on the ith day.
 * You may choose a single day to buy one NeetCoin and choose a different day in the future to sell it.
 * Return the maximum profit you can achieve. You may choose to not make any transactions, in which case the profit would be 0.
 * Example 1:
 * Input: prices = [10,1,5,6,7,1]
 * Output: 6
 * Explanation: Buy prices[1] and sell prices[4], profit = 7 - 1 = 6.
 * Example 2:
 * Input: prices = [10,8,7,5,2]
 * Output: 0
 */
public class BuySellStock {

    public int maxProfit(int[] prices) {

        if(prices.length==1){
            return 0;
        }

        int i = 0;
        int j = 1;
        int maxProfit = 0;

        while(j< prices.length){
            if(prices[j]<prices[i]){
                i=j;
            }else{
                int profit = prices[j] - prices[i];
                if(profit>maxProfit){
                    maxProfit = profit;
                }
            }
            j++;
        }

        return maxProfit;

    }

    public static void main(String[] args) {
        int[] input1 = {10,1,5,6,7,1};
        int[] input2 = {10,8,7,5,2};

        BuySellStock obj = new BuySellStock();
        System.out.println(obj.maxProfit(input1));
        System.out.println(obj.maxProfit(input2));
    }

}
