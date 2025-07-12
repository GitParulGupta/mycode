package com.example.practice.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintAllContiguousSubarray {

    public List<List<Integer>> solution(List<Integer> l){


        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0;i<l.size();i++){
            List<Integer> temp = new ArrayList<>();
            temp.add(l.get(i));
            ans.add(new ArrayList<>(temp));
            for(int j=i+1;j<l.size();j++){
                temp.add(l.get(j));
                ans.add(new ArrayList<>(temp));
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        List<Integer> input = List.of(1,2,3,4);
        PrintAllContiguousSubarray obj = new PrintAllContiguousSubarray();
        List<List<Integer>> ans = obj.solution(input);

        for(List<Integer> l:ans){
            l.forEach(System.out::print);
            System.out.print("\n");
        }
    }

}
