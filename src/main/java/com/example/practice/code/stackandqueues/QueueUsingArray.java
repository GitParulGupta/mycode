package com.example.practice.code.stackandqueues;

public class QueueUsingArray {

    int start = -1;
    int end = -1;

    int[] array;

    public QueueUsingArray(){
        array = new int[5];
    }

    public void add(int x){
        if(start==-1){
            start++;
            array[start] = x;
            end=start;
        }else if((end+1)%(array.length) == start){
            throw new RuntimeException("Queue is full");
        }else{
            end = (end+1)%(array.length);
            array[end] = x;
        }
    }

    public int remove(){
        if(start==-1){
            throw new RuntimeException("Queue is empty");
        }else{
            int ans = array[start];
            start = (start+1)%(array.length);
            return ans;
        }
    }

    public int peek(){
        if(start==-1){
            throw new RuntimeException("Queue is empty");
        }else{
            return array[start];
        }
    }

    public static void main(String[] args) {
        String[] operation = {"QueueUsingArray","push","push","push","push","push","push","pop","peek","pop","push"};
        int[] num = {-1,0,1,3,4,5,6,-1,-1,-1,2};
        QueueUsingArray obj = new QueueUsingArray();

        for(int i=0;i<operation.length;i++){
            try {
                switch (operation[i]){
                    case "QueueUsingArray":
                        obj = new QueueUsingArray();
                        break;
                    case "push":
                        obj.add(num[i]);
                        System.out.println("Added element: "+num[i]);
                        break;
                    case "peek":
                        System.out.println(operation[i]+ " " + obj.peek());
                        break;
                    case "pop":
                        System.out.println(operation[i]+ " " + obj.remove());
                        break;
                    default:
                        System.out.println("Invalid operation");
                }
            }catch (RuntimeException e){
                System.out.println(e.getMessage());
            }
        }
    }

}
