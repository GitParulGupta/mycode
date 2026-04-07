package com.example.practice.code;

import java.util.LinkedList;
import java.util.List;

/**
 * This is also called page replacement algo
 * Given memory capacity (as number of pages it can hold) and a string representing pages to be referred, write a function to find number of page faults.
 */
public class LRUCachePageFaults {

    private List<Integer> list;
    private int pageFaults = 0;
    private int cacheSize;

    public LRUCachePageFaults(int capacity) {
        cacheSize = capacity;
        this.list = new LinkedList<Integer>();
    }

    public int getPageFaults(){
        return pageFaults;
    }

    public void addPage(int page){
        if(!list.contains(page)){
            pageFaults++;
        }else{
            list.remove(Integer.valueOf(page));
        }
        list.add(page);
        if(list.size()>cacheSize){
            list.remove(0);
        }
    }

    public static void main(String[] args) {
        int[] input = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2};
        int capacity = 4;

        LRUCachePageFaults lruCache = new LRUCachePageFaults(capacity);
        for(int i:input){
            lruCache.addPage(i);
            System.out.println("Current page: "+i+" Page faults: "+lruCache.getPageFaults());
        }

    }
}
