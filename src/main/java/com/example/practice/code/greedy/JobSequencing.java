package com.example.practice.code.greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * You are given a set of N jobs where each job comes with a deadline and profit. The profit can only be earned upon completing the job within its deadline. Find the number of jobs done and the maximum profit that can be obtained. Each job takes a single unit of time and only one job can be performed at a time.
 * Example 1:
 * Input: N = 4, Jobs = {(1,4,20),(2,1,10),(3,1,40),(4,1,30)}
 * Output: 2 60
 * Example 2:
 * Input: N = 5, Jobs = {(1,2,100),(2,1,19),(3,2,27),(4,1,25),(5,1,15)}
 * Output: 2 125
 */
public class JobSequencing {

    public int[] maxProfitJobs(int[][] jobs){

        List<Jobs> jobList = new ArrayList<>();

        for(int i=0;i<jobs.length;i++){
            Jobs job = new Jobs(jobs[i][0],jobs[i][1],jobs[i][2]);
            jobList.add(job);
        }

        jobList.sort(new Comparator<Jobs>() {
            @Override
            public int compare(Jobs o1, Jobs o2) {
                if(o1.getDeadline()==o2.getDeadline()){
                    return o2.getProfit()-o1.getProfit();
                }else{
                    return o1.getDeadline()-o2.getDeadline();
                }
            }
        });

        int numDaysPassed = 0;
        int profit = 0;
        int jobsCompleted = 0;
        for(int i=0;i< jobList.size();i++){
            if(numDaysPassed<jobList.get(i).getDeadline()){
                numDaysPassed = Math.max(jobList.get(i).getDeadline(),numDaysPassed);
                profit = profit + jobList.get(i).getProfit();
                jobsCompleted++;
            }
        }
        return new int[]{jobsCompleted,profit};
    }

    public static void main(String[] args) {
        int[][] jobs = {{1,4,20},{2,1,10},{3,1,40},{4,1,30}};
        JobSequencing obj = new JobSequencing();
        int[] result= obj.maxProfitJobs(jobs);
        System.out.println("Max num jobs: "+result[0]+" Max profit: "+result[1]);


        int[][] jobs2 = {{1,2,100},{2,1,19},{3,2,27},{4,1,25},{5,1,15}};
        int[] result2= obj.maxProfitJobs(jobs2);
        System.out.println("Max num jobs: "+result2[0]+" Max profit: "+result2[1]);
    }

}

class Jobs{
    private int id;
    private int deadline;
    private int profit;

    public Jobs(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }

    public int getId() {
        return id;
    }

    public int getDeadline() {
        return deadline;
    }

    public int getProfit() {
        return profit;
    }
}