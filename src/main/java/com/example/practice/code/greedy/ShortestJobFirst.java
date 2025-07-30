package com.example.practice.code.greedy;

import java.util.Arrays;

/**
 * A software engineer is tasked with using the shortest job first (SJF) policy to calculate the average waiting time for each process. The shortest job first also known as shortest job next (SJN) scheduling policy selects the waiting process with the least execution time to run next.
 * Given an array of n integers representing the burst times of processes, determine the average waiting time for all processes and return the closest whole number that is less than or equal to the result.
 * Examples:
 * Input : bt = [4, 1, 3, 7, 2]
 * Output : 4
 * Explanation : The total waiting time is 20.
 * So the average waiting time will be 20/5 => 4.
 * Input : bt = [1, 2, 3, 4]
 * Output : 2
 * Explanation : The total waiting time is 10.
 * So the average waiting time will be 10/4 => 2.
 *
 * SJF - scheduling process which selects the job with the smallest execution time
 */
public class ShortestJobFirst {

    public long solve(int[] bt) {
        long completionTime = 0;
        long waitingTime = 0;

        Arrays.sort(bt);

        for(int i=0;i<bt.length;i++){
            waitingTime = waitingTime + completionTime;
            completionTime = completionTime+bt[i];
        }

        return Math.round(waitingTime/bt.length);
    }

    public static void main(String[] args) {
        ShortestJobFirst sjf = new ShortestJobFirst();

        int[] bt1 = {4,1,3,7,2};
        System.out.println("for Array: "+Arrays.toString(bt1)+" ans: "+sjf.solve(bt1));

        int[] bt2 = {1,2,3,4};
        System.out.println("for Array: "+Arrays.toString(bt2)+" ans: "+sjf.solve(bt2));
    }
}
