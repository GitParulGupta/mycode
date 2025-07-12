package com.example.practice.code;

import lombok.Builder;
import lombok.Setter;
import lombok.Value;

import java.util.ArrayList;
import java.util.Optional;

public class MyHashMap {

    ArrayList<Entries> hashMap;
    private final Entries invalidEntry = new Entries(-1,-1);

    public MyHashMap(){
        hashMap = new ArrayList<>();
    }

    public void put(int key, int value){
        Optional<Entries> currentEntry = hashMap.stream().filter(a->a.key()==key).findFirst();
        Entries newEntry = new Entries(key,value);
        currentEntry.ifPresent(entries -> hashMap.remove(entries));
        hashMap.add(newEntry);
    }

    public void remove(int key){
        Optional<Entries> currentEntry = hashMap.stream().filter(a->a.key()==key).findFirst();
        currentEntry.ifPresent(entries -> hashMap.remove(entries));
    }

    public int get(int key){
        return hashMap.stream().filter(a->a.key()==key).findFirst().orElse(invalidEntry).value();
    }

    public static void main(String[] args) {

    }

}

@Setter
@Builder
record Entries(int key, int value) {
}