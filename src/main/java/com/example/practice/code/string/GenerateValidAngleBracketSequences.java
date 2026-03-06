package com.example.practice.code.string;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given n, return all valid sequences of n pairs of '<' and '>' with proper nesting.
 *
 * Examples
 * Example 1
 * Input:
 *
 * n = 1
 * Output:
 *
 * <>
 * n = 2
 * Output:
 * <><>,<<><>>
 */
public class GenerateValidAngleBracketSequences {

    public List<String> generateValidStrings(int n) {
        List<String> result = new ArrayList<>();

        Queue<State> queue = new LinkedList<>();

        queue.offer(new State("",0,0));

        while (!queue.isEmpty()) {

            State state = queue.poll();

            if(state.current.length()==2*n){
                result.add(state.current);
                continue;
            }

            if(state.open<n){
                queue.offer(new State(state.current+"<", state.open+1,state.close));
            }

            if(state.close<state.open){
                queue.offer(new State(state.current+">",state.open,state.close+1));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        GenerateValidAngleBracketSequences s = new GenerateValidAngleBracketSequences();
        System.out.println(s.generateValidStrings(2));
    }
}


class State{
    String current;
    int open;
    int close;

    public State(String current, int open, int close){
        this.current = current;
        this.open = open;
        this.close = close;
    }
}
