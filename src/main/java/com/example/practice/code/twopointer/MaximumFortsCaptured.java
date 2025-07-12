package com.example.practice.code.twopointer;


import com.example.practice.code.MajorityElement;

/**
 * You are given a 0-indexed integer array forts of length n representing the positions of several forts. forts[i] can be -1, 0, or 1 where:
 * -1 represents there is no fort at the ith position.
 * 0 indicates there is an enemy fort at the ith position.
 * 1 indicates the fort at the ith the position is under your command.
 * Now you have decided to move your army from one of your forts at position i to an empty position j such that:
 * 0 <= i, j <= n - 1
 * The army travels over enemy forts only. Formally, for all k where min(i,j) < k < max(i,j), forts[k] == 0.
 * While moving the army, all the enemy forts that come in the way are captured.
 * Return the maximum number of enemy forts that can be captured. In case it is impossible to move your army, or you do not have any fort under your command, return 0.
 * Example 1:
 *
 * Input: forts = [1,0,0,-1,0,0,0,0,1]
 * Output: 4
 * Explanation:
 * - Moving the army from position 0 to position 3 captures 2 enemy forts, at 1 and 2.
 * - Moving the army from position 8 to position 3 captures 4 enemy forts.
 * Since 4 is the maximum number of enemy forts that can be captured, we return 4.
 * Example 2:
 * Input: forts = [0,0,1,-1]
 * Output: 0
 * Explanation: Since no enemy fort can be captured, 0 is returned.
 */
public class MaximumFortsCaptured {

    public int captureForts(int[] forts) {

        if(forts.length==1){
            return 0;
        }

        int i=0;
        int j=1;
        int maxCount = 0;

        while(i<forts.length && j<forts.length){
            if(forts[i]==1 || forts[i]==-1){
                if(forts[j]==0){
                    j++;
                }else if((forts[j]==1 || forts[j]==-1) && forts[i]!=forts[j]){
                    int count = j-i-1;
                    maxCount = Math.max(count,maxCount);
                    i=j;
                    j=i+1;
                }else{
                    i=j;
                    j=i+1;
                }
            }else{
                i++;
                j++;
            }
        }

        return maxCount;

    }

    public static void main(String[] args) {
        int[] forts1 = {1,0,0,-1,0,0,0,0,1};
        int[] forts2 = {1,0,0,-1,0,0,-1,0,0,1};
        int[] forts3 = {0,0,-1,1};

        MaximumFortsCaptured maximumFortsCaptured = new MaximumFortsCaptured();
        System.out.println("Output for forts1 " + maximumFortsCaptured.captureForts(forts1));
        System.out.println("Output for forts2 " + maximumFortsCaptured.captureForts(forts2));
        System.out.println("Output for forts3 " + maximumFortsCaptured.captureForts(forts3));
    }

}
