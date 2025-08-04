package com.example.practice.code.greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * There is one meeting room in a firm. You are given two arrays, start and end each of size N.For an index ‘i’, start[i] denotes the starting time of the ith meeting while end[i]  will denote the ending time of the ith meeting. Find the maximum number of meetings that can be accommodated if only one meeting can happen in the room at a  particular time. Print the order in which these meetings will be performed.
 * Example:
 * Input:  N = 6,  start[] = {1,3,0,5,8,5}, end[] =  {2,4,5,7,9,9}
 * Output: 1 2 4 5
 */
public class NMeeting {

    //For a class which stores, start time, endTime and index and sort the list of class objects in order of decreasing time
    //question can be asked in 2 ways - return meeting number or retun count of meetings that can be planned.
    public List<Integer> solution(int[] start, int[] end, int n){

        List<Meeting> meetingList = new ArrayList<>();

        List<Integer> result = new ArrayList<>();

        for(int i=0;i<n;i++){
            Meeting m = new Meeting(start[i],end[i],i+1);
            meetingList.add(m);
        }

        meetingList.sort(new Comparator<Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
                return o1.getEndTime()-o2.getEndTime();
            }
        });

        int freeTime = meetingList.get(0).getEndTime();

        result.add(meetingList.get(0).getIndex());

        for(int i=1;i<n;i++){
            if(freeTime<meetingList.get(i).getStartTime()){
                freeTime = meetingList.get(i).getEndTime();
                result.add(meetingList.get(i).getIndex());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 6;  int start[] = {1,3,0,5,8,5}; int end[] =  {2,4,5,7,9,9};

        NMeeting obj = new NMeeting();
        obj.solution(start,end,n).stream().forEach(System.out::print);
    }
}

class Meeting{

    private int startTime;
    private int endTime;
    private int index;

    public Meeting(int startTime, int endTime, int index) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.index = index;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public int getIndex() {
        return index;
    }
}

