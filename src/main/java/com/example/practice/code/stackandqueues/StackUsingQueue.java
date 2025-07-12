package com.example.practice.code.stackandqueues;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

    Queue<Integer> stack;
    Queue<Integer> helper;

    public StackUsingQueue() {
        stack = new LinkedList<>();
        helper = new LinkedList<>();
    }

    public void push(int x) {

        Iterator<Integer> i = stack.iterator();
        helper = new LinkedList<>();
        while(i.hasNext()){
            Integer num = i.next();
            helper.add(num);
        }
        stack = new LinkedList<>();
        stack.add(x);

        stack.addAll(helper);
    }

    public int pop() {
        return stack.remove();
    }

    public int top() {
        return stack.peek();
    }

    public boolean empty() {
        return stack.isEmpty();
    }

}
