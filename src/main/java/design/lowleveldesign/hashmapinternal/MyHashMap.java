package design.lowleveldesign.hashmapinternal;

public class MyHashMap<K,V> {

    public static int INITIAL_CAPACITY = 16;
    public static int MAX_CAPACITY = 1 << 30;

    Entry[] hashTable;

    public MyHashMap() {
        hashTable = new Entry[INITIAL_CAPACITY];
    }

    public MyHashMap(int initialCapacity) {
        int tableSize = findTableSizeFor(initialCapacity);
        hashTable = new Entry[tableSize];
    }

    public int findTableSizeFor(int capacity){
        int n = capacity-1;
        n|=n>>1;
        n|=n>>2;
        n|=n>>4;
        n|=n>>8;
        n|=n>>16;
        return (n<0)?1:((n>=MAX_CAPACITY)?MAX_CAPACITY:1);
    }

    public void put(K key, V value){
        int hash = key.hashCode()%hashTable.length;
        Entry node = hashTable[hash];

        if(node==null){
            node = new Entry(key, value);
            hashTable[hash] = node;
        }else{
            while(node.next!=null){
                if(node.next.key.equals(key)){
                    node.next.value=value;
                    return;
                }
                node = node.next;
            }
            Entry newNode = new Entry(key, value);
            node.next = newNode;
        }
    }

    public V get(K key){
        int hash = key.hashCode()%hashTable.length;
        Entry node = hashTable[hash];
        while(node!=null){
            if(node.key.equals(key)){
                return (V)node.value;
            }
            node = node.next;
        }
        return null;
    }
}

class Entry<K,V>{
    K key;
    V value;
    public Entry next;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
        next = null;
    }
}