package com.example.practice.code.stackandqueues;

public class StackUsingArray {

    int top = -1;
    int[] array;
    int arraySize;

    public StackUsingArray(int n){
        this.arraySize = n;
        array = new int[arraySize];
    }

    public void push(int i){
        if(top>=arraySize){
            throw new RuntimeException("Stack is full");
        }
        else {
            top++;
            array[top] = i;
        }
    }

    public int top(){
        if(top==-1){
            throw new RuntimeException("Stack is Empty");
        }
        return array[top];
    }

    public int pop(){
        if(top==-1){
            throw new RuntimeException("Stack is Empty");
        }
        int ans = array[top];
        top--;
        return ans;
    }

}
