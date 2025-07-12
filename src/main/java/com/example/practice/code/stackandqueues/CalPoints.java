package com.example.practice.code.stackandqueues;

import java.util.Stack;

/**
 * Baseball Game
 * You are keeping the scores for a baseball game with strange rules. At the beginning of the game, you start with an empty record.
 *
 * Given a list of strings operations, where operations[i] is the ith operation you must apply to the record and is one of the following:
 *
 * An integer x: Record a new score of x.
 * '+': Record a new score that is the sum of the previous two scores.
 * 'D': Record a new score that is the double of the previous score.
 * 'C': Invalidate the previous score, removing it from the record.
 * Return the sum of all the scores on the record after applying all the operations.
 */
public class CalPoints {

    public int calPoints(String[] operations) {

        Stack<Integer> s = new Stack<>();

        for (String operation : operations) {
            switch (operation) {
                case "+" -> {

                    int v1 = s.pop();
                    int v2 = s.pop();

                    int sum = v1 + v2;
                    s.push(v2);
                    s.push(v1);
                    s.push(sum);
                }
                case "D" -> {

                    int v = s.pop();
                    s.push(v);
                    s.push(2 * v);
                }
                case "C" -> s.pop();
                case null, default -> s.push(Integer.valueOf(operation));
            }
        }

        int result = 0;

        while(!s.isEmpty()){
            result = result + s.pop();
        }

        return result;

    }

    public static void main(String[] args) {
        CalPoints obj = new CalPoints();
        String[] operations = {"1","2","+","C","5","D"};
        System.out.println(obj.calPoints(operations));
    }

}
