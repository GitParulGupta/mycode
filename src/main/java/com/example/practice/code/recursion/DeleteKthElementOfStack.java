package com.example.practice.code.recursion;


import java.util.Stack;

/**
 * Given a stack, remove the Kth element from the top of stack
 * k = size of stack/2 +1;
 */
public class DeleteKthElementOfStack {

    public void deleteElement(Stack<Integer> s, int n){

        if(n==0){
            return;
        }
        int k = (n/2)+1;
        solveUsingRecursion(s,k);
    }

    private void solveUsingRecursion(Stack<Integer> s, int k){
        if(k==1){
            s.pop();
            return;
        }
        int temp = s.pop();
        solveUsingRecursion(s,k-1);
        s.push(temp);
    }

    public static void main(String[] args) {
        DeleteKthElementOfStack obj = new DeleteKthElementOfStack();

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        obj.deleteElement(stack,5);


        stack.stream().forEach(System.out::println);

    }


}
