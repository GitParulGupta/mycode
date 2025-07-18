package com.example.practice.code.slidingWindow;

public class NumberOfNiceSubarrays {

    public int solutionBruteForce(int[] nums, int k){
        int count = 0;

        for(int i=0;i<nums.length;i++){
            int oddCount = 0;

            for(int j=i;j<nums.length;j++){
                if(nums[j]%2!=0){
                    oddCount++;
                }
                if(oddCount==k){
                    count++;
                }
            }
        }

        return count;
    }

    /**
     * This problem is similar to BinarySubArrays with Sum
     * Ex: [1,5,2,1,1]
     * Convert it to 1,0 st if number is odd, then susbstitute as 1 and if even substitute as 0
     * ==> [1,1,0,1,1]
     * Given k = 3 , nothing but goal sum in BinarySubArrays
     * @param nums
     * @param k
     * @return
     */
    public int solutionOptimal(int[] nums, int k){
        int[] temp = new int[nums.length];

        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0){
                temp[i] = 0;
            }else {
                temp[i] = 1;
            }
        }

        BinarySubarraysWithSum obj = new BinarySubarraysWithSum();
        return obj.solution(temp,k)-obj.solution(temp,k-1);
    }

    public static void main(String[] args) {
        int[] input = {2,2,2,1,2,2,1,2,2,2};
        int k = 2;

        NumberOfNiceSubarrays obj = new NumberOfNiceSubarrays();
        System.out.println(obj.solutionOptimal(input,k));


        int[] input2 = {1,1,2,1,1};
        int k2 = 3;

        System.out.println(obj.solutionOptimal(input2,k2));
    }


}
