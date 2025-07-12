package com.example.practice.code.stackandqueues;

import java.util.Arrays;
import java.util.Stack;

/**
 * Next Greater element is first element greater than the element at a[i] on the right of a[i]
 */
public class NextGreaterElement {

    public int[] solution(int[] a){
        int n = a.length;
        int[] ans = new int[n];

        Stack<Integer> st = new Stack<>();

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=a[i]){
                st.pop();
            }

            if(st.isEmpty()){
                ans[i] = -1;
            }else{
                ans[i] = st.peek();
            }
            st.push(a[i]);
        }

        return ans;
    }

    /**
     * Consider the given array a is circular
     * Ex: a = {1,4,2,3}
     * For solution we double the array hypothetically {1,4,2,3,1,4,2,3} =>indexes {0,1,2,3,4,5,6,7} & n =4
     * 4 => 4%n=0
     * Solution 1: start loop from 0->n-1
     * then 2 inner loops, for any i -> i+1-> n-1 and second 0 -> i-1
     */
    public int[] solution2(int[] a){
        int n = a.length;
        int[] ans = new int[n];

        Stack<Integer> st = new Stack<>();

        for(int i=2*n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=a[i%n]){
                st.pop();
            }

            if(i<n){
                if(st.isEmpty()){
                    ans[i] = -1;
                }else{
                    ans[i] = st.peek();
                }
            }
            st.push(a[i%n]);
        }

        return ans;
    }


    public static void main(String[] args) {
        int[] a = {1,4,2,3};

        NextGreaterElement obj = new NextGreaterElement();

        int[] ans = obj.solution(a);
        int[] ans3 = obj.solution2(a);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(ans));
        System.out.println(Arrays.toString(ans3));
    }

}
