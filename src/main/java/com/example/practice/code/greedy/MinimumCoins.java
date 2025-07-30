package com.example.practice.code.greedy;

import java.util.Arrays;
import java.util.Collections;

/**
 * Given an integer array of coins representing coins of different denominations and
 * an integer amount representing a total amount of money. Return the fewest number of coins that are needed to make up
 * that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 * There are infinite numbers of coins of each type
 * Examples:
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1. We need 3 coins to make up the amount 11.
 * Input: coins = [2, 5], amount = 3
 * Output: -1
 * Explanation: It's not possible to make amount 3 with coins 2 and 5. Since we can't combine the coin 2 and 5 to make the amount 3, the output is -1.
 */
public class MinimumCoins {

    public int solution(int[] coins, int value){

        Arrays.sort(coins);

        int i = coins.length-1;
        int remainingValue = value;
        int coinCount = 0;
        while(remainingValue>0 && i>-1){

            if(coins[i]<=remainingValue){
                int numCoins = Math.round(remainingValue/coins[i]);
                coinCount = coinCount+numCoins;
                remainingValue = remainingValue - (numCoins*coins[i]);
            }
            i--;

        }

        if(remainingValue==0){
            return coinCount;
        }else{
            return -1;
        }
    }

    public static void main(String[] args) {
        MinimumCoins obj = new MinimumCoins();

        int[]coins = {1, 2, 5}; int amount = 11;
        System.out.println("For Array: "+Arrays.toString(coins)+" amount: "+amount+" ans: "+obj.solution(coins,amount));

        int[]coins1 = {2, 5}; int amount1 = 3;
        System.out.println("For Array: "+Arrays.toString(coins1)+" amount: "+amount1+" ans: "+obj.solution(coins1,amount1));
    }

}
