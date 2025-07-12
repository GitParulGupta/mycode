package com.example.practice.code.binarysearch;

/**
 * Find floor of sqrt of a given number n
 */
public class SqrtUsingBS {

    public long solution(int n){
        int low = 1;
        int high = n;
        int res = 0;

        while(low<=high){
            int mid = low + (high-low)/2;
            long val = (long) mid *mid;
            if(val<n){
                res = mid;
                low = mid + 1;
            }else if(val>n){
                high = mid - 1;
            }else{
                return mid;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SqrtUsingBS obj = new SqrtUsingBS();
        System.out.println(obj.solution(26));
        System.out.println(obj.solution(2147395600));
    }

}
