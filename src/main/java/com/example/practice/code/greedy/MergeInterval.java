package com.example.practice.code.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 * Example 1:
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 * Example 2:
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * Constraints:
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 */
public class MergeInterval {

    public int[][] mergeInterval(int[][] arr){

        if(arr.length==1){
            return arr;
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        List<Intervals> resultList = new ArrayList<>();
        int startIndex;
        if(arr[0][1]<arr[1][0]){
            resultList.add(new Intervals(arr[0][0],arr[0][1]));
            startIndex = 1;
        }else{
            Intervals newInterval = new Intervals(Math.min(arr[0][0],arr[1][0]),Math.max(arr[0][1],arr[1][1]));
            resultList.add(newInterval);
            startIndex = 2;
        }

        while (startIndex<arr.length){
            if(resultList.getLast().end()<arr[startIndex][0]){
                resultList.add(new Intervals(arr[startIndex][0],arr[startIndex][1]));
            }else{
                Intervals newInterval = new Intervals(Math.min(resultList.getLast().start(),arr[startIndex][0]),Math.max(resultList.getLast().end(),arr[startIndex][1]));
                resultList.removeLast();
                resultList.add(newInterval);
            }
            startIndex++;
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
        int[][] interval1 = {{1,3},{2,6},{8,10},{15,18}};
        MergeInterval obj = new MergeInterval();
        int[][] result = obj.mergeInterval(interval1);
        for(int[] i:result){
            System.out.print(Arrays.toString(i)+"\n");
        }

        System.out.println("*******");
        int[][] interval2 = {{1,4},{4,5}};
        int[][] result2 = obj.mergeInterval(interval2);
        for(int[] i:result2){
            System.out.print(Arrays.toString(i)+"\n");
        }
    }

}