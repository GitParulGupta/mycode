package com.example.practice.code.greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * There is one meeting room in a firm. You are given two arrays, start and end each of size N.For an index ‘i’, start[i] denotes the starting time of the ith meeting while end[i]  will denote the ending time of the ith meeting. Find the maximum number of meetings that can be accommodated if only one meeting can happen in the room at a  particular time. Print the order in which these meetings will be performed.
 Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
 Note that intervals which only touch at a point are non-overlapping. For example, [1, 2] and [2, 3] are non-overlapping.
 Example 1:
 Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
 Output: 1
 Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
 Example 2:
 Input: intervals = [[1,2],[1,2],[1,2]]
 Output: 2
 Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.
 Example 3:
 Input: intervals = [[1,2],[2,3]]
 Output: 0
 Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 Constraints:
 1 <= intervals.length <= 105
 intervals[i].length == 2
 -5 * 104 <= starti < endi <= 5 * 104
 */
public class NonOverlappingInterval {

    public int solution(int[][] intervals){

        List<Interval> intervalList = new ArrayList<>();

        for(int i=0;i<intervals.length;i++){
            Interval it = new Interval(intervals[i][0],intervals[i][1]);
            intervalList.add(it);
        }

        intervalList.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.end()-o2.end();
            }
        });

        int freeTime = intervalList.get(0).end();
        List<Interval> result = new ArrayList<>();
        result.add(intervalList.get(0));

        for(int i=1;i<intervalList.size();i++){
            if(intervalList.get(i).start()>=freeTime){
                freeTime = intervalList.get(i).end();
                result.add(intervalList.get(i));
            }
        }
        return intervals.length-result.size();
    }

    public static void main(String[] args) {
        int[][] interval1 = {{1,2},{2,3},{3,4},{1,3}};
        NonOverlappingInterval obj= new NonOverlappingInterval();
        System.out.println(obj.solution(interval1));
    }
}

record Interval(int start, int end){}

