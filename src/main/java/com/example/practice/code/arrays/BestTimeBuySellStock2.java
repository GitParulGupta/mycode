package com.example.practice.code.arrays;

/**
 * You have been given stock values/prices for N number of days. Every i-th day signifies the price of a stock on that day. Your task is to find the maximum profit which you can make by buying and selling the stocks.
 * Note :
 * You may make as many transactions as you want but can not have more than one transaction at a time i.e, if you have the stock, you need to sell it first, and then only you can buy it again.
 * Example 1:
 * Input: prices = [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4. Then buy on day 4 and sell on day 5 profit is 3. TOtal profit is 7
 * Example 2:
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 */
public class BestTimeBuySellStock2 {

    public long solution1(long[] values){
        if(values.length<=1){
            return 0;
        }

        long profit = 0;
        long tempMaxProfit = 0;
        long maxProfit = 0;

        long startPrice = values[0];
        for(int i=1;i<values.length;i++){
            if(values[i]<values[i-1]){
                maxProfit+=tempMaxProfit;
                tempMaxProfit=0;
                startPrice = values[i];
            }else{
                startPrice = Math.min(startPrice,values[i]);
            }
            profit = values[i]-startPrice;
            tempMaxProfit = Math.max(profit,tempMaxProfit);
        }

        maxProfit+=tempMaxProfit;

        return maxProfit;
    }

    public static void main(String[] args) {
        long[] prices = {7,1,5,3,6,4};
        BestTimeBuySellStock2 obj = new BestTimeBuySellStock2();
        System.out.println(obj.solution1(prices));
    }

}
