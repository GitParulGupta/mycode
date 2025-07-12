package com.example.practice.code.arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * Given a list of intervals, merge the overlapping intervals and return the resultant list
 * Example: {(1,3),(2,6),(8,9),(9,11),(8,10),(2,4),(15,18),(16,17)}
 * Result: {(1,6),(8,11),(15,18)}
 * Brute force: sort and then compare each set with all the other sets, Complexity: O(nlogn)+O(n^2)
 * Optimal solution: reduce O(n^2) to O(n)
 */
public class MergeOverlappingIntervals {

    public List<List<Integer>> solution(List<List<Integer>> l1){

        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> l=l1.stream().sorted(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                if(!Objects.equals(o1.get(0), o2.get(0))){
                    return o1.get(0).compareTo(o2.get(0));
                }else{
                    return o1.get(1).compareTo(o2.get(1));
                }
            }
        }).toList();

        result.add(l.getFirst());

        for(int i=1;i<l.size();i++){
            int curStart = result.getLast().getFirst();
            int curEnd = result.getLast().getLast();

            if(curEnd>l.get(i).getFirst()){
                //overlapping

                if(curEnd<l.get(i).getLast()){
                    List<Integer> temp = List.of(curStart, l.get(i).getLast());
                    result.removeLast();
                    result.add(temp);
                }

            }else{
                result.add(l.get(i));
            }
        }


        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> input = List.of(List.of(1,3),List.of(2,6),List.of(8,9),List.of(9,11),List.of(8,10),List.of(2,4),List.of(15,18),List.of(16,17));
        MergeOverlappingIntervals obj = new MergeOverlappingIntervals();
        List<List<Integer>> result =obj.solution(input);

        for(List<Integer> l : result){
            System.out.println(l);
        }
    }

}
