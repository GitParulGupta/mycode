package com.example.practice.code.recursion;


/**
 * You have been given an integer 'num'. Write a function to calculate descriptive word form of the number.
 * Use the India standard unit of numbering.
 * Example :
 * If the given input is 62, the output should be 'Sixty two' (without quotes).
 * Similarly, if the input is 1000000, the output should be 'Ten lakh'.
 */
public class GivenNumberToStringIndian {

    private static final String[] lessThan10 = {"Zero","one","two","three","four","five","six","seven","eight","nine"};
    private static final String[] lessThan20 = {"Ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
    private static final String[] lessThan100 = {"","","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
    private static StringBuilder res;

    public String solution(int num){

        if(num==0){
            return "zero";
        }
        res = new StringBuilder();
        makeNumber(num);
        if(res.length()>0){
            char c = res.charAt(0);
            char cUpper = Character.toUpperCase(c);
            res.setCharAt(0,cUpper);
        }
        return res.toString().trim();
    }

    private void makeNumber(int num){

        if(num==0){
            return;
        }else if(num<10){
            res.append(lessThan10[num]).append(" ");
        }else if(num<20){
            res.append(lessThan20[num%10]).append(" ");
        }else if(num<100){
            res.append(lessThan100[num/10]).append(" ");
            makeNumber(num%10);
        }else if(num<1000){
            res.append(lessThan10[num/100]).append(" hundred ");
            makeNumber(num%100);
        }else if(num<1000000){
            makeNumber(num/1000);
            res.append("thousand ");
            makeNumber(num%1000);
        }else if(num<10000000){
            makeNumber(num/100000);
            res.append("lakh ");
            makeNumber(num%100000);
        }else if(num<1000000000){
            makeNumber(num/10000000);
            res.append("crore ");
            makeNumber(num%10000000);
        }else{
            makeNumber(num/1000000000);
            res.append("arab ");
            makeNumber(num%1000000000);
        }
    }

    public static void main(String[] args) {

        int[] nums = {24,234,4567,567899,2389417,234567899};

        GivenNumberToStringIndian obj = new GivenNumberToStringIndian();

        for(int i=0;i<nums.length;i++){
            System.out.println("num:" +nums[i]+" string:"+obj.solution(nums[i]));
        }
    }

}
