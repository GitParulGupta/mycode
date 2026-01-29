package design.lowleveldesign.hashmapinternal;

public class Main {

    public static void main(String[] args) {

        MyHashMap<Integer,String> map = new MyHashMap<>(7);

        map.put(1,"a");
        map.put(2,"b");
        map.put(3,"c");
        map.put(4,"d");
        map.put(5,"e");
        map.put(6,"f");
        map.put(7,"g");
        map.put(8,"h");


        System.out.println(map.get(8));
        System.out.println(map.get(1));
        System.out.println(map.get(10));


    }
}
