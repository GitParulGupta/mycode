package com.example.practice.code.recursion;

import java.sql.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BasicRecursion {

    public void printNameNTimes(String name, int n, int counter){

        if(counter>n){
            return;
        }
        System.out.println("Printing Name:"+name);
        printNameNTimes(name,n,counter+1);
    }


    public void printNLinearNumbers(int n, int currentNumber){

        if(currentNumber>n){
            return;
        }
        System.out.println(currentNumber);
        printNLinearNumbers(n,currentNumber+1);
    }

    public void printNLinearNumbersReverse(int n){

        if(n==0){
            return;
        }
        System.out.println(n);
        printNLinearNumbersReverse(n-1);
    }

    public void printNLinearNumbersBacktracking(int i, int n){

        if(i<1){
            return;
        }
        printNLinearNumbersBacktracking(i-1,n);
        System.out.println(i);
    }

    public void printNLinearNumbersReverseBacktracking(int i, int n){

        if(i>n){
            return;
        }
        printNLinearNumbersReverseBacktracking(i+1,n);
        System.out.println(i);
    }

    public void sumOfFirstNNaturalNumbersParameter(int i, int sum){
        if(i==0){
            System.out.println(sum);
            return;
        }
        sumOfFirstNNaturalNumbersParameter(i-1,sum+i);
    }

    public int sumOfFirstNNaturalNumbersFunctional(int i){
        if(i==0){
            return 0;
        }
        return i+sumOfFirstNNaturalNumbersFunctional(i-1);
    }

    public void factorialOfNParameter(int n, int factorial){
        if(n==0){
            System.out.println(factorial);
            return;
        }
        factorialOfNParameter(n-1,factorial*n);
    }

    public int factorialOfNFunction(int n){
        if(n==1){
            return 1;
        }
        return n*factorialOfNFunction(n-1);
    }

    public void reverseArrayRecursion2Pointer(int left, int right, int[] a){
        if(left>=right){
            System.out.println(Arrays.toString(a));
            return;
        }
        int temp = a[left];
        a[left] = a[right];
        a[right] = temp;
        reverseArrayRecursion2Pointer(left+1, right-1,a);
    }

    public void reverseArrayRecursion1Pointer(int index, int[] a){
        int n = a.length;
        if(index>=n/2){
            System.out.println(Arrays.toString(a));
            return;
        }

        int temp = a[index];
        a[index] = a[n-index-1];
        a[n-index-1] = temp;
        reverseArrayRecursion1Pointer(index+1, a);
    }

    public boolean checkStringPalindrome(int index, String s){
        int n = s.length();
        if(index>=n/2){
            return true;
        }
        if(s.charAt(index)!=s.charAt(n-1-index))
            return false;
        return checkStringPalindrome(index+1,s);
    }

    /**
     * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
     * F(0) = 0, F(1) = 1
     * F(n) = F(n - 1) + F(n - 2), for n > 1.
     * Given n, calculate F(n).
     */
    public int fibonacciNumber(int n) {

        if(n==0)
            return 0;
        if(n==1)
            return 1;

        return fibonacciNumber(n-1)+fibonacciNumber(n-2);
    }

    public static void main(String[] args) {
        BasicRecursion obj = new BasicRecursion();
        System.out.println("PrintNameNTimes");
        obj.printNameNTimes("ABC",5,1);
        System.out.println("printNLinearNumbers");
        obj.printNLinearNumbers(10,1);
        System.out.println("printNLinearNumbersReverse");
        obj.printNLinearNumbersReverse(10);
        System.out.println("printNLinearNumbersBacktracking");
        obj.printNLinearNumbersBacktracking(3,3);
        System.out.println("printNLinearNumbersReverseBacktracking");
        obj.printNLinearNumbersReverseBacktracking(1,3);
        System.out.println("sumOfFirstNNaturalNumbersParameter");
        obj.sumOfFirstNNaturalNumbersParameter(3,0);
        System.out.println("sumOfFirstNNaturalNumbersFunctional: "+obj.sumOfFirstNNaturalNumbersFunctional(3));
        System.out.println("factorialOfNParameter");
        obj.factorialOfNParameter(3,1);
        System.out.println("factorialOfNFunction: "+obj.factorialOfNFunction(3));

        int[] a = {1,2,3,5,4};
        System.out.println("reverseArrayRecursion2Pointer: ");
        obj.reverseArrayRecursion2Pointer(0,a.length-1,a);

        int[] a1 = {1,2,3,5,4};
        System.out.println("reverseArrayRecursion1Pointer: ");
        obj.reverseArrayRecursion1Pointer(0,a1);

        String s1 ="madam";
        String s2="abcdddfcba";
        System.out.println("checkStringPalindrome for String: "+ s1+" :"+obj.checkStringPalindrome(0,s1));
        System.out.println("checkStringPalindrome for String: "+ s2+" :"+obj.checkStringPalindrome(0,s2));

        System.out.println("fibonacciNumber:"+obj.fibonacciNumber(4));
    }



}
