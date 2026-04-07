package com.example.practice.code;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 * Implement the LRUCache class:
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * The functions get and put must each run in O(1) average time complexity.
 */
public class LRUCache {

    private final LinkedHashMap<Integer, Integer> map;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    //if we dont enable access order = true, it will not act as a cache but will only run in creation mode and maintain insertion order
    //load factor is the value after which cache resize. Default load factor is 1.
    //In a LinkedHashMap, the two mechanisms serve different purposes and operate at different times within the put() operation:
    //The removeEldestEntry() method is checked first, after a new entry has been inserted into the map.
    //The load factor is checked second, as part of a potential resizing operation, which only occurs if the size after the removeEldestEntry() check still exceeds the capacity threshold.
    public LRUCache(int capacity) {
        map = new LinkedHashMap<Integer, Integer>(capacity,1.0f, true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return map.size() > capacity;
            }
        };
    }

    public int get(int key) {
        lock.writeLock().lock(); //get value can be changed if put operation occurred
        try{
            return map.getOrDefault(key,-1);
        }finally {
            lock.readLock().unlock();
        }
    }

    public void put(int key, int value) {
        lock.writeLock().lock();
        try{
            map.put(key, value);
        }finally {
            lock.writeLock().unlock();
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = null;
        String[] operation = {"LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"};
        int[][] input = {{2}, {1, 1}, {2, 2}, {1}, {3, 3}, {2}, {4, 4}, {1}, {3}, {4}};

        for(int i = 0; i < operation.length; i++){
            switch (operation[i]) {
                case "LRUCache":
                    lruCache=new LRUCache(input[i][0]);
                    break;
                    case "put":
                        lruCache.put(input[i][0],input[i][1]);
                        System.out.println("");
                        break;
                        case "get":
                            System.out.println(lruCache.get(input[i][0]));
            }
        }

    }
}
