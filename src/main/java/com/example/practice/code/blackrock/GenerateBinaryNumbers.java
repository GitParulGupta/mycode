package com.example.practice.code.blackrock;

import java.util.ArrayList;
import java.util.List;


/**
 * Your friend Ninja has been learning about binary numbers lately. In order to understand binary numbers with perfection, Ninja asks you to generate a list of binary numbers from 1 to ‘N’, which he can use later for reference.
 * For every integer Ninja gives, your task is to generate all the binary numbers from 1 to ‘N’.
 * Example:
 * Consider N = 5,
 * All the binary numbers from 1 to 5 are: 1, 10, 11, 100, 101.
 */
public class GenerateBinaryNumbers {

    public static List<String> generateBinaryNumbers(int n) {

        List<String> result = new ArrayList<>();

        for(int i=1;i<=n;i++){
            String binaryString = Integer.toBinaryString(i);
            result.add(binaryString);
        }

        return result;

    }

    public static void main(String[] args) {
        System.out.println(generateBinaryNumbers(10));
    }
}
