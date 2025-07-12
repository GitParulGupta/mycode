package com.example.practice.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyHashSet {

    ArrayList<Integer> set;

    public MyHashSet(){
        set = new ArrayList<>();
    }

    private void printElements(){
        System.out.println("Start printing list");
        for(Integer i:set){
            System.out.print(i);
        }
        System.out.println("\nCompleted printing list");
    }

    public void add(int key){
        if(!containsKey(key)){
            set.add(key);
        }
    }

    public void remove(int key){
        if(containsKey(key)){
            set.remove(Integer.valueOf(key));
        }
    }

    public boolean containsKey(int key){
        boolean keyExist = false;
        for(Integer i:set){
            if(key==i){
                keyExist = true;
                break;
            }
        }
        return keyExist;
    }

    public static void main(String[] args) {
        List<String> operation = Arrays.asList("MyHashSet","add","add","contains","contains","add","contains","remove","contains");
        List<Integer> integers = Arrays.asList(0,1,2,1,3,3,2,2,2);

        MyHashSet myHashSet = new MyHashSet();

        for(int i=0;i<operation.size();i++){
            switch (operation.get(i)){
                case "MyHashSet":
                    myHashSet = new MyHashSet();
                    myHashSet.printElements();
                    break;
                case "add":
                    myHashSet.add(integers.get(i));
                    myHashSet.printElements();
                    break;
                case "remove":
                    myHashSet.remove(integers.get(i));
                    myHashSet.printElements();
                    break;
                case "contains":
                    System.out.println(myHashSet.containsKey(integers.get(i)));
                    break;
            }
        }

    }

}
