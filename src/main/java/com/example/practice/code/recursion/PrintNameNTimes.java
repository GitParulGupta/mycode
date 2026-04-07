package com.example.practice.code.recursion;

public class PrintNameNTimes {
    public void printNameNTimes(int n, String s) {
        if(n==0) return;
        System.out.println(s);
        printNameNTimes(n-1,s);
    }

    public static void main(String[] args) {
        PrintNameNTimes pnt = new PrintNameNTimes();
        pnt.printNameNTimes(4,"aa");
    }

}
