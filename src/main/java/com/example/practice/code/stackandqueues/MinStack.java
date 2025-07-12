package com.example.practice.code.stackandqueues;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

import java.util.Stack;

/**
 * Algo to implement push pop top getMin and size operations in O(1)
 */
public class MinStack {

    Stack<Pair> minStack;

    MinStack(){
        minStack = new Stack<>();
    }

    void push(int a){
        Pair p;
        if(minStack.isEmpty()){
           p = new Pair(a,a);
        }else{
            p = new Pair(a,Math.min(a,minStack.peek().getMin()));
        }

        minStack.push(p);
    }

    int pop(){
        if(minStack.isEmpty()){
            return -1;
        }
        return minStack.pop().getValue();
    }

    int getMin(){
        if(minStack.isEmpty()){
            return -1;
        }
        return minStack.peek().getMin();
    }

    int top(){
        if(minStack.isEmpty()){
            return -1;
        }
        return minStack.peek().getValue();
    }

    public static void main(String[] args) {
        String[] input = {"MinStack","push","push","push","getMin","pop","top","getMin"};
        int[] numInput = {-1,-2,0,-3,-1,-1,-1,-1};

        MinStack obj = new MinStack();

        for(int i=0;i<input.length;i++){
            switch (input[i]){
                case "MinStack":
                    obj= new MinStack();
                    break;
                case "push":
                    obj.push(numInput[i]);
                    break;
                case "pop":
                    System.out.println(obj.pop());
                    break;
                case "getMin":
                    System.out.println(obj.getMin());
                    break;
                case "top":
                    System.out.println(obj.top());
                    break;
            }
        }
    }

}

@Getter
class Pair{
    int value;
    int min;

    Pair(int value, int min){
        this.value = value;
        this.min = min;
    }

    public int getValue() {
        return value;
    }

    public int getMin() {
        return min;
    }
}
