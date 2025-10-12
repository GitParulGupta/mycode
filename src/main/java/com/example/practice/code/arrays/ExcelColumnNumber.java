package com.example.practice.code.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * You have been given a column title as appears in an Excel sheet, return its corresponding column number.
 * For example:
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 */
public class ExcelColumnNumber {

    public long excelColumnNumber(String input) {
        int sum = 0;
        int n = input.length();

        for(int i=0;i<n;i++){

            char curChar = input.charAt(i);
            sum = 26*sum+curChar-'A'+1;
        }

        return sum;
    }

    public static void main(String[] args) {
        String s = "ABC";
        ExcelColumnNumber obj = new ExcelColumnNumber();
        System.out.print(obj.excelColumnNumber(s));
    }

}
