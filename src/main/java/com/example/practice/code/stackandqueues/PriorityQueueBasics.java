package com.example.practice.code.stackandqueues;

import java.util.*;

public class PriorityQueueBasics {

    public static void main(String[] args) {

        Queue<Integer> q = new PriorityQueue<>();

        q.add(2);
        q.add(5);
        q.add(26);
        q.add(3);
        q.add(1);
        q.add(7);
        q.add(11);
        System.out.println("/*****************/");
        for (Integer integer : q) {
            System.out.println(integer);
        }

        Queue<Integer> q1 = new PriorityQueue<>(Collections.reverseOrder());

        q1.add(2);
        q1.add(5);
        q1.add(26);
        q1.add(3);
        q1.add(1);
        q1.add(7);
        q1.add(11);
        q1.remove();
        System.out.println(q1.isEmpty());

        System.out.println("/*****************/");
        for (Integer integer : q1) {
            System.out.println(integer);
        }


        System.out.println("/*****************/");
        Queue<Student> q2 = new PriorityQueue<>(new StudentComparator());
        Student s1 = new Student(12,"a");
        Student s2 = new Student(11,"b");
        q2.add(s1);
        q2.add(s2);

        for (Student s:q2){
            System.out.println(s.id+" "+s.name);
        }
    }

}

class Student{
    int id;
    String name;

    Student(int id, String name){
        this.id = id;
        this.name = name;
    }
}

class StudentComparator implements Comparator<Student>{

    @Override
    public int compare(Student o1, Student o2) {
        if(o1.id<o2.id){
            return -1;
        }else if(o1.id>o2.id){
            return 1;
        }else{
            return 0;
        }
    }
}