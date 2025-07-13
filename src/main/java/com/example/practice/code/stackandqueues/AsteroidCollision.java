package com.example.practice.code.stackandqueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * We are given an array asteroids of integers representing asteroids in a row. The indices of the asteriod in the array represent their relative position in space.
 * For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
 * Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
 * Example 1:
 * Input: asteroids = [5,10,-5]
 * Output: [5,10]
 * Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
 * Example 2:
 * Input: asteroids = [8,-8]
 * Output: []
 * Explanation: The 8 and -8 collide exploding each other.
 * Example 3:
 * Input: asteroids = [10,2,-5]
 * Output: [10]
 * Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
 * Constraints:
 * 2 <= asteroids.length <= 104
 * -1000 <= asteroids[i] <= 1000
 * asteroids[i] != 0
 * Example: {4,7,1,1,2,-3,-7,11,-15,19} ans = {-15, 19}
 */
public class AsteroidCollision {

    public int[] solution(int[] input){

        List<Integer> st = new ArrayList<>();

        for(int i=0;i<input.length;i++){

            if(input[i]>0){
                st.add(input[i]);//adding +ve element
            }else{

                while(!st.isEmpty() && st.getLast()>0 && st.getLast()<Math.abs(input[i])){
                    st.removeLast();
                }

                if(!st.isEmpty() && st.getLast()==Math.abs(input[i])){
                    st.removeLast();
                }else if(st.isEmpty() || st.getLast()<0){
                    st.add(input[i]);
                }

            }

        }

        int[] result = new int[st.size()];
        int i=0;
        for(int el:st){
            result[i]=el;
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        AsteroidCollision obj = new AsteroidCollision();
        int[] input1 = {5,10,-5};
        int[] input2 = {8,-8};
        int[] input3 = {10,2,-5};
        int[] input4 = {4,7,1,1,2,-3,-7,11,-15,19};

        System.out.println("For array: "+ Arrays.toString(input1)+" solution from brute force approach: "+Arrays.toString(obj.solution(input1)));

        System.out.println("For array: "+ Arrays.toString(input2)+" solution from brute force approach: "+Arrays.toString(obj.solution(input2)));

        System.out.println("For array: "+ Arrays.toString(input3)+" solution from brute force approach: "+Arrays.toString(obj.solution(input3)));

        System.out.println("For array: "+ Arrays.toString(input4)+" solution from brute force approach: "+Arrays.toString(obj.solution(input4)));
    }

}
