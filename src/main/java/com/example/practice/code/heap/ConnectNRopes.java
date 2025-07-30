package com.example.practice.code.heap;

import java.util.PriorityQueue;

/**
 * You have some sticks with positive integer lengths. You can connect any two sticks together to form a longer stick by paying a cost equal to the sum of their lengths. You must connect all the sticks into one single stick.
 * Return the minimum cost of connecting all the sticks.
 * Examples:
 * Input: sticks = [2, 4, 3]
 * Output: 14
 * Explanation:
 * Connect sticks 2 and 3 → cost = 2 + 3 = 5 (sticks = [5, 4]),
 * Connect sticks 4 and 5 → cost = 4 + 5 = 9 (sticks = [9]),
 * Total cost = 5 + 9 = 14
 * Input: sticks = [1, 8, 3, 5]
 * Output: 30
 * Explanation:
 * Connect 1 and 3 → cost = 1 + 3 = 4 (sticks = [4, 8, 5]),
 * Connect 4 and 5 → cost = 4 + 5 = 9 (sticks = [9, 8]),
 * Connect 8 and 9 → cost = 8 + 9 = 17 (sticks = [17]),
 * Total cost = 4 + 9 + 17 = 30
 *
 * Approach: in order to get minimum cost we need to pick minimum length sticks and add them together ==>minheap
 */
public class ConnectNRopes {

    public int solution(int[]a){

        if(a.length==1){
            return a[0];
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i:a){
            minHeap.add(i);
        }

        int tCost = 0;

        while(minHeap.size()>=2){
            int l1 = minHeap.poll();
            int l2 = minHeap.poll();
            tCost = tCost+l1+l2;
            minHeap.add(l1+l2);
        }

        return tCost;

    }

    public static void main(String[] args) {
        int[] a = {2,4,3};
        int[] b = {1,8,3,5};

        ConnectNRopes obj = new ConnectNRopes();

        System.out.println(obj.solution(a));

        System.out.println(obj.solution(b));
    }

}
