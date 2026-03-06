package com.example.practice.code.maths;

/**
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 * Example 1:
 *
 * Input: x = 123
 * Output: 321
 * Example 2:
 *
 * Input: x = -123
 * Output: -321
 * Example 3:
 *
 * Input: x = 120
 * Output: 21
 *
 *
 * Constraints:
 *
 * -231 <= x <= 231 - 1
 *
 */
public class ReverseNumber {

    public int reverse(int x) {

        long reversedX = 0;

        int temp = x<0? Math.abs(x):x;
        while(temp>0){
            int lastDigit = temp%10;
            if(((reversedX*10)+(lastDigit)) > Integer.MAX_VALUE){
                return 0;
            }

            reversedX = (reversedX*10)+lastDigit;
            temp = temp/10;
        }

        if(x<0){
            reversedX = -1*reversedX;
        }

        return (int)reversedX;
    }

    public static void main(String[] args) {
        ReverseNumber reverseNumber = new ReverseNumber();
        //System.out.println(reverseNumber.reverse(123));
        //System.out.println(reverseNumber.reverse(-123));
        System.out.println(reverseNumber.reverse(1534236469));
    }
}
