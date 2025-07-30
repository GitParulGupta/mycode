package com.example.practice.code.heap;


import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given a 2-D array where column 0 represents x coordinates and column 1 represents y coordinates. Return k closest points to origin.
 * Distance between any 2 points x1,y1 and x2,y2 is sqrt( (x2-x1)^2+(y2-y1)^2)
 */
public class KClosestPointsToOrigin {

    public int[][] solution(int[][] points, int k){

        PriorityQueue<Points> maxHeap = new PriorityQueue<>(new Comparator<Points>() {
            @Override
            public int compare(Points o1, Points o2) {
                return o2.getDistance()-o1.getDistance();
            }
        });

        for (int[] point : points) {
            Points p = new Points(point[0], point[1]);
            maxHeap.add(p);
            while (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] result = new int[2][2];
        int i = 0;
        while (!maxHeap.isEmpty()){
            Points temp = maxHeap.poll();
            result[i][0] = temp.getX();
            result[i][1] = temp.getY();
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] i1 = {{1,3},{-2,2},{5,6},{4,5}};

        KClosestPointsToOrigin obj = new KClosestPointsToOrigin();
        int[][] res=obj.solution(i1,2);
        for(int[] l:res){
            System.out.println(Arrays.toString(l));
        }
    }

}

class Points{
    int distance;
    int x;
    int y;


    public Points(int x, int y) {
        this.x = x;
        this.y = y;
        this.distance = (int) Math.sqrt(Math.pow(x,2)+Math.pow(y,2));//distance of point x,y from origin
    }

    public int getDistance() {
        return distance;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
