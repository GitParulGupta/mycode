package com.example.practice.code.binarysearch;


/**
 * Given a sorted array. Find the number of occurences of given Integer x in array. Return 0 if element does not exist.
 */
public class NumberOccurrence {

    public int numberOfOccurrences(int[] input, int target){

        FirstNLastOccurrenceOfNumberBS obj = new FirstNLastOccurrenceOfNumberBS();

        int first = obj.findFirstOccurrence(input,target);
        int last = obj.findLastOccurrence(input,target);

        if(first!=-1 && last != -1){
            return last - first + 1;
        }else{
            return 0;
        }

    }

    public static void main(String[] args) {
        int[] a = {2,4,6,8,8,8,11,13};

        int[] target = {2,6,8,13,14};

        NumberOccurrence obj = new NumberOccurrence();

        for(int i:target){
            System.out.println("Occurrences of " + i+" = "+obj.numberOfOccurrences(a,i));
        }
    }

}
