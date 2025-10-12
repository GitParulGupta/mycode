package com.example.practice.code.maths;

import java.util.Scanner;

/**
 * Given a number N, find its square root. You need to find and print only the integral part of square root of N.
 * For eg. if number given is 18, answer is 4.
 *
 * Here main method is given in editor.
 * Test is to use the scanner to tkae the input and evaluate sqrt
 */
public class SquareRootIntegral {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        System.out.println("Enter number");
        int input = scn.nextInt();

        System.out.println((int)Math.sqrt(input));
    }
}
