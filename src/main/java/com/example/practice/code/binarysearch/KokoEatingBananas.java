package com.example.practice.code.binarysearch;

/**
 * Important: Atlassian
 * A monkey is given ‘n’ piles of bananas, where the 'ith' pile has ‘a[i]’ bananas. An integer ‘h’ is also given, which denotes the time (in hours) in which all the bananas should be eaten.
 * Each hour, the monkey chooses a non-empty pile of bananas and eats ‘m’ bananas. If the pile contains less than ‘m’ bananas, then the monkey consumes all the bananas and won’t eat any more bananas in that hour.
 * Find the minimum number of bananas ‘m’ to eat per hour so that the monkey can eat all the bananas within ‘h’ hours.
 * Example:
 * Input: ‘n’ = 4, ‘a’ =  [3, 6, 2, 8] , ‘h’ = 7
 * Output: 3
 * Explanation: If ‘m’ = 3, then
 * The time taken to empty the 1st pile is 1 hour.
 * The time taken to empty the 2nd pile is 2 hour.
 * The time taken to empty the 3rd pile is 1 hour.
 * The time taken to empty the 4th pile is 3 hour.
 * Therefore, a total of 7 hours is taken. It can be shown that if the rate of eating bananas is reduced, they can’t be eaten in 7 hours.
 */
public class KokoEatingBananas {

    /**
     * Brute force solution
     * start by taking m = 1
     * for each m value find number of total hours needed to eat all the bananas
     * if it exceeds given h hours, then move to next value of m
     */

    /**
     * Better Solution but Time Limit exception
     * we know minimum koko can eat 1 banana. For max, in this range, find maximum bananas in pile.
     * so m can range from 1 to max(arr)
     * Then check for each value of m
     */

    /**
     * optimised solution - Binary Search on answers - very very important
     * we know minimum koko can eat 1 banana. For max, in this range, find maximum bananas in pile.
     * Perform binary search on this range by storing possible answers
     */

    public static int solution(int[] ar, int h){

        int maxArray = maxArrayElement(ar);

        int low = 1;
        int high = maxArray;
        int ans = 0;

        while(low<=high){
            int mid = (low+high)/2;
            int totalTime = calculateTotalTime(ar,mid);
            if(totalTime<=h){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }


        return ans;

    }

    private static int calculateTotalTime(int[] ar, int hourlyRate) {
        int totalTime = 0;
        for(int i: ar){
            totalTime += Math.ceil((double)i/hourlyRate);
        }
        return totalTime;
    }

    private static int maxArrayElement(int[] ar){
        int maxArray = Integer.MIN_VALUE;

        for(int i:ar){
            maxArray = Math.max(maxArray,i);
        }
        return maxArray;
    }

    public static void main(String[] args) {
        int[] ar = {3,6,7,15};
        int h = 8;

        //KokoEatingBananas k = new KokoEatingBananas();
        System.out.println(KokoEatingBananas.solution(ar,h));
    }

}
