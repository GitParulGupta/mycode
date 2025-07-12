package com.example.practice.code.stackandqueues;

import java.util.Arrays;
import java.util.Stack;

/**
 * Next Smaller element is first element smaller than the element at a[i] on the right of a[i]
 */
public class NextSmallerElement {

    public int[] solution(int[] a){
        int n = a.length;
        int[] ans = new int[n];

        Stack<Integer> st = new Stack<>();

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()>=a[i]){
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

    public static void main(String[] args) {
        int[] a = {1,4,2,3};

        NextSmallerElement obj = new NextSmallerElement();

        int[] ans = obj.solution(a);
        System.out.println(Arrays.toString(a));

        System.out.println(Arrays.toString(ans));
    }

}
