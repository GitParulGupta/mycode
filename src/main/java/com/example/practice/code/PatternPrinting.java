package com.example.practice.code;

import java.util.Map;

public class PatternPrinting {

    /**
     * 1
     * 1 2
     * 1 2 3
     * 1 2 3 4
     */
    public void print1(){
        System.out.println("Pattern 1");
        for(int i=1;i<=4;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j);
            }
            System.out.print("\n");
        }
    }

    /**
     * 1 2 3 4
     * 1 2 3
     * 1 2
     * 1
     */
    public void print1Rev(){
        System.out.println("Pattern 1 Rev");
        for(int i=4;i>=1;i--){
            for(int j=1;j<=i;j++){
                System.out.print(j);
            }
            System.out.print("\n");
        }
    }

    /**
     * 1
     * 2 2
     * 3 3 3
     * 4 4 4 4
     */
    public void print2(){
        System.out.println("Pattern 2");
        for(int i=1;i<=4;i++){
            for(int j=1;j<=i;j++){
                System.out.print(i);
            }
            System.out.print("\n");
        }
    }

    /**
     *       1
     *     2 2 2
     *   3 3 3 3 3
     * 4 4 4 4 4 4 4
     */
    public void print3(int n){
        System.out.println("Pattern 3");
        for(int i=1;i<=n;i++){
            int left = n-i;
            int right = n+i;

            for(int j=1;j<=left;j++){
                System.out.print(" ");
            }

            for(int j=left+1;j<=right-1;j++){
                System.out.print(i);
            }
            for(int j=right;j<=2*n-1;j++){
                System.out.print(" ");
            }

            System.out.print("\n");
        }
    }

    /**
     *       1
     *     2 2 2
     *   3 3 3 3 3
     * 4 4 4 4 4 4 4
     *   3 3 3 3 3
     *     2 2 2
     *       1
     */
    public void print4(int n){
        System.out.println("Pattern 3");
        for(int i=1;i<=n;i++){
            int left = n-i;
            int right = n+i;

            for(int j=1;j<=left;j++){
                System.out.print(" ");
            }

            for(int j=left+1;j<=right-1;j++){
                System.out.print(i);
            }
            for(int j=right;j<=2*n-1;j++){
                System.out.print(" ");
            }

            System.out.print("\n");
        }

        for(int i=n-1;i>=1;i--){
            int left = n-i;
            int right = n+i;

            for(int j=1;j<=left;j++){
                System.out.print(" ");
            }

            for(int j=left+1;j<=right-1;j++){
                System.out.print(i);
            }
            for(int j=right;j<=2*n-1;j++){
                System.out.print(" ");
            }

            System.out.print("\n");
        }
    }

    /**
     * 1             1
     * 2 2         2 2
     * 3 3 3     3 3 3
     * 4 4 4 4 4 4 4 4
     */
    public void print7(int n){
        System.out.println("Pattern 7");
        int space = 2*(n-1);
        for(int i=1;i<=n;i++) {

            //nums
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }

            for (int j = 1; j <= space; j++) {
                System.out.print(" ");
            }

            for (int j = i; j >= 1; j--) {
                System.out.print(j);
            }
            System.out.print("\n");
            space -= 2;
        }
    }

    /**
     * 1
     * 0 1
     * 1 0 1
     * 0 1 0 1
     */
    public void print5(int n){
        System.out.println("Pattern 5");
        int rowStart = 1;
        for(int i=1;i<=n;i++){
            int temp = rowStart;
            for(int j=1;j<=i;j++){
                System.out.print(temp);
                temp = Math.abs(temp-1);
            }
            rowStart = Math.abs(rowStart-1);
            System.out.print("\n");
        }
    }

    /**
     * A
     * A B
     * A B C
     * A B C D
     */
    public void print6(int n){
        System.out.println("Pattern 6");
        for(int i=0;i<n;i++){
            //int count = 1;
            /*for(char ch='A';ch<='Z';ch++){
                if(count<=i) {
                    System.out.print(ch);
                }
                count++;
            }*/
            for(char ch='A';ch<='A'+i;ch++){
                System.out.print(ch);
            }
            System.out.print("\n");
        }
    }

    /**
     * A
     * B B
     * C C C
     * D D D D
     */
    public void print8(int n){
        System.out.println("Pattern 8");

        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print((char)('A'+(i-1)));
            }
            System.out.print("\n");
        }
    }


    public static void main(String[] args) {
        PatternPrinting obj = new PatternPrinting();
        obj.print1();
        obj.print1Rev();
        obj.print2();
        obj.print3(4);
        obj.print4(4);
        obj.print5(5);
        obj.print6(7);
        obj.print7(4);
        obj.print8(4);
    }

}
