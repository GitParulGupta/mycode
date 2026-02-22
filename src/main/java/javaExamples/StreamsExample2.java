package javaExamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsExample2 {

    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<>();

        list.add(List.of("A", "B", "C"));
        list.add(List.of("D", "E", "F"));
        list.add(List.of("G", "H", "I"));

        //To flatten to List<String>

        List<String> l = list.stream().flatMap(l1->l1.stream().map(String::toLowerCase)).toList();
        System.out.println(l);


        int[] ar = {1,2,3,4,1,5,7,7,3};
        List<Integer> l2 = Arrays.stream(ar).distinct().boxed().toList();

        Stream<Integer> s = Arrays.stream(ar).map(a->a%2).peek(a->System.out.print(a)).boxed();
        System.out.println(s.collect(Collectors.toList()));

        Arrays.stream(ar).limit(3).boxed().forEach(System.out::print);

    }
}
