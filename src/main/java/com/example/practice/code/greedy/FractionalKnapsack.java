package com.example.practice.code.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * The weight of N items and their corresponding values are given. We have to put these items in a knapsack of weight W such that the total value obtained is maximized.
 * Note: We can either take the item as a whole or break it into smaller units.
 * Example:
 * Input: N = 3, W = 50, values[] = {100,60,120}, weight[] = {20,10,30}.
 * Output: 240.00
 * Explanation: The first and second items  are taken as a whole  while only 20 units of the third item is taken. Total value = 100 + 60 + 80 = 240.00
 */
public class FractionalKnapsack {

    public double solution(int[] weights, int[] value, int bag){

        Item[] items = new Item[value.length];

        for(int i=0;i<value.length;i++){
            Item item = new Item(value[i],weights[i]);
            items[i] = item;
        }

        //sorting in dec value/weight
        Arrays.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                double item1Ratio = o1.value/o1.weight;
                double item2Ratio = o2.value/o2.weight;
                return (int)item2Ratio - (int)item1Ratio;
            }
        });

        double currentWeight = 0;
        double currentValue = 0;

        for(int i=0;i<value.length;i++){
            if(currentWeight+items[i].weight<=bag){
                currentWeight+=items[i].weight;
                currentValue+=items[i].value;
            }else{
                double remainingWeight = bag - currentWeight;
                currentValue = currentValue+(remainingWeight/items[i].weight)*items[i].value;
            }
        }
        return currentValue;
    }

    public static void main(String[] args) {
        int bag = 50; int values[] = {100,60,120}; int weight[] = {20,10,30};

        FractionalKnapsack obj = new FractionalKnapsack();
        System.out.println(obj.solution(weight,values,bag));
    }

}

class Item{
    int value;
    int weight;
    public Item(int value, int weight){
        this.weight = weight;
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }
}