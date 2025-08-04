package com.example.practice.code.greedy;

import java.util.LinkedHashSet;
import java.util.List;

/**
 * In operating systems that use paging for memory management, page replacement algorithm are needed to decide which page needed to be replaced when new page comes in. Whenever a new page is referred and not present in memory, page fault occurs and Operating System replaces one of the existing pages with newly needed page. Different page replacement algorithms suggest different ways to decide which page to replace.
 * The target for all algorithms is to reduce number of page faults.
 * In Least Recently Used (LRU) algorithm is a Greedy algorithm where the page to be replaced is least recently used. The idea is based on locality of reference, the least recently used page is not likely
 * Example:  page reference string 7 0 1 2 0 3 0 4 2 3 0 3 2 . Initially we have 4 page slots empty
 * Ans: 6 page faults
 * Explanation: 7,0,1,2 ---> empty slots so 4 page faults
 * 0 --> no page fault
 * 3 --> remove 7 and add 3 --> 1 page fault
 * 0--> no page fault - already there
 * 4 --> remove 1 add 4 --> 1 page fault
 * 2 --> no page fault
 * 3 --> no page fault
 * 0 --> no page fault
 * 3 --> no page fault
 * 2 --> no page fault
 * Final order of oages in memeory --> 4032
 */
public class LRUPageReplacement {

    public int countPageFaults(int[] pages, int allowedSize){

        LinkedHashSet<Integer> cacheMemory = new LinkedHashSet<>();
        int pageFaults =0;
        for(int i=0;i<pages.length;i++){

            if(cacheMemory.contains(pages[i])){
                cacheMemory.remove(pages[i]);
                cacheMemory.add(pages[i]);
            }else{
                pageFaults++;

                if(cacheMemory.size()==allowedSize){
                    int first = cacheMemory.iterator().next();
                    cacheMemory.remove(first);
                }
                cacheMemory.add(pages[i]);

            }

        }

        return pageFaults;

    }

    public List<Integer> finalPagesInMemory(int[] pages, int allowedSize){

        LinkedHashSet<Integer> cacheMemory = new LinkedHashSet<>();
        for(int i=0;i<pages.length;i++){

            if(cacheMemory.contains(pages[i])){
                cacheMemory.remove(pages[i]);
                cacheMemory.add(pages[i]);
            }else{
                if(cacheMemory.size()==allowedSize){
                    int first = cacheMemory.iterator().next();
                    cacheMemory.remove(first);
                }
                cacheMemory.add(pages[i]);

            }

        }

        return cacheMemory.stream().toList();

    }


    public static void main(String[] args) {
        int[] pages= {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2};
        LRUPageReplacement lruObj = new LRUPageReplacement();
        System.out.println("Page faults: "+lruObj.countPageFaults(pages,4));

        lruObj.finalPagesInMemory(pages,4).stream().forEach(System.out::print);

    }

}
