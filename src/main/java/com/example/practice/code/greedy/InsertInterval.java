package com.example.practice.code.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
 * Return intervals after the insertion.
 * Note that you don't need to modify intervals in-place. You can make a new array and return it.
 * Example 1:
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * Example 2:
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 */
public class InsertInterval {

    public int[][] insertIntervals(int[][] arr, int[] newInterval){

        List<Intervals> resultList = new ArrayList<>();

        int i=0;

        while(i<arr.length && arr[i][1]<newInterval[0]){
            resultList.add(new Intervals(arr[i][0],arr[i][1]));
            i++;
        }

        while(i<arr.length && arr[i][0]<=newInterval[1]){

            newInterval[0] = Math.min(newInterval[0],arr[i][0]);
            newInterval[1] = Math.max(newInterval[1],arr[i][1]);
            i++;
        }
        resultList.add(new Intervals(newInterval[0],newInterval[1]));

        while(i<arr.length){
            resultList.add(new Intervals(arr[i][0],arr[i][1]));
            i++;
        }

        int[][] result = new int[resultList.size()][2];
        int k = 0;
        for(Intervals it: resultList){
            result[k][0]=it.start();
            result[k][1]=it.end();
            k++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] interval1 = {{1,3},{6,9}};
        int[] newInterval1 = {2,5};
        InsertInterval obj = new InsertInterval();
        int[][] result = obj.insertIntervals(interval1,newInterval1);
        for(int[] i:result){
            System.out.print(Arrays.toString(i)+"\n");
        }

        System.out.println("*******");
        int[][] interval2 = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval2 = {4,8};
        int[][] result2 = obj.insertIntervals(interval2,newInterval2);
        for(int[] i:result2){
            System.out.print(Arrays.toString(i)+"\n");
        }
    }

}

record Intervals(int start, int end){
}
