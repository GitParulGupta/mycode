package com.example.practice.code;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.*;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {

        int[] solution = new int[k];

        Map<Integer, Element> elementMap = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(elementMap.containsKey(nums[i])){
                Element currentElement = elementMap.get(nums[i]);
                currentElement.setFrequency(currentElement.frequency+1);

            }else{
                Element newElement = new Element(nums[i],i,1);
                elementMap.put(nums[i],newElement);
            }
        }

        List<Element> possibleList = elementMap.values().stream().sorted(new SortByFrequency()).toList();

        for(int j=0;j<k;j++){
            solution[j] = possibleList.get(j).value;
        }

        System.out.println(possibleList);

        return solution;

    }

    public static void main(String[] args) {
        int[] input = {4,1,-1,2,-1,2,3};

        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();

        int[] result = topKFrequentElements.topKFrequent(input,2);

        System.out.println(Arrays.toString(result));
    }

}

class Element {
    int value;
    int currentIndex;
    int frequency;

    public Element(int value, int currentIndex, int frequency){
        this.value = value;
        this.currentIndex = currentIndex;
        this.frequency = frequency;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Element element = (Element) o;
        return value == element.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, currentIndex, frequency);
    }
}

class SortByFrequency implements Comparator<Element>{

    @Override
    public int compare(Element o1, Element o2) {
        return o2.frequency-o1.frequency;
    }
}
