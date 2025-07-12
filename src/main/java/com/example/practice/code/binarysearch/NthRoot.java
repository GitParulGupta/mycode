package com.example.practice.code.binarysearch;


/**
 * Given a number m, return the nth root of the given number. Return -1 if the nth root does not exist.
 */
public class NthRoot {
    public int solution(int givenNumber, int nthRoot){
       int low = 1;
       int high = givenNumber;

       while(low<=high){
           int mid = (low+high)/2;
           int midN = direction(mid, nthRoot, givenNumber);
           if(midN==0){
               return mid;
           }else if(midN==1){
               low = mid+1;
           }else{
               high=mid-1;
           }
       }
       return -1;
    }


    /**
     * return 0 if ans == m
     * return 1 if ans < m
     * return 2 if ans > m
     * @param mid
     * @param n
     * @param m
     * @return
     */
    private int direction(int mid, int n, int m){
        long ans = 1;
        for(int i=1;i<=n;i++){
            ans = ans*mid;
            System.out.println("Calc ans = "+ans);
            if(ans>m){
                System.out.println("Breaking and returning 2");
                return 2;
            }
        }
        if(ans<m) return 1;
        return 0;
    }

    public static void main(String[] args) {
        NthRoot obj = new NthRoot();
        System.out.println(obj.solution(81,4));
        System.out.println(obj.solution(25,3));
    }

}
