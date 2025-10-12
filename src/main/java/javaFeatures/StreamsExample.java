package javaFeatures;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

//Introduced in java 8
public class StreamsExample {

    public static void main(String[] args) {

        List<Integer> numArray = List.of(1,4,6,2,7, 2, 7,7);
        List<String> stringArray = List.of("abc","acc","acem","bdc","asmkf","aba");

        // Filter even numbers
        System.out.println("Filter even Numbers");
        numArray.stream().filter(x->x%2==0).toList().forEach(System.out::println);

        // Find the max number in a list
        System.out.println("\nFind the max number in a list");
        System.out.println(numArray.stream().max(Integer::compare));

        // Sort in reverse order
        System.out.println("\nSort in reverse order");
        numArray.stream().sorted(Collections.reverseOrder()).toList().forEach(System.out::print);

        // Count strings with a specific prefix
        System.out.println("\nCount strings with a specific prefix");
        System.out.println(stringArray.stream().filter(x->x.startsWith("a")).count());

        // Find the first non-repeated character in a string
        System.out.println("\nFind the first non-repeated character in a string");
        String input = "swiss";
        System.out.println(input.chars().mapToObj(c->(char)c).filter(c -> input.indexOf(c)==input.lastIndexOf(c)).findFirst());

        // Convert list of strings to uppercase
        System.out.println("\nConvert list of strings to uppercase");
        stringArray.stream().map(String::toUpperCase).toList().forEach(System.out::println);

        // Calculate the sum of numbers
        System.out.println("\nCalculate the sum of numbers");
        System.out.println(numArray.stream().mapToInt(Integer::intValue).sum());

        // Check if any string matches a condition
        System.out.println("\nCheck if any string matches a condition");
        System.out.println(stringArray.stream().anyMatch(s->s.contains("abc")));

        //Integer to frequency map from array
        System.out.println("\nInteger to frequency map from array");
        Map<Integer,Long> numCountMap = numArray.stream().collect(groupingBy(Integer::intValue,counting()));
        System.out.print("\nKeys: ");numCountMap.keySet().forEach(System.out::print);
        System.out.print("\nValues: ");numCountMap.values().forEach(System.out::print);

        // Find duplicates in a list
        System.out.println("\nFind duplicates in a list");
        Set<Integer> numSet = new HashSet<>();
        numArray.stream().filter(c->!numSet.add(c)).toList().forEach(System.out::print);

        // Group strings by length
        System.out.println("\nGroup strings by length");
        System.out.println(stringArray.stream().collect(Collectors.groupingBy(String::length)));

        // Flatten nested lists
        List<List<Integer>> nestedList = Arrays.asList(List.of(1,2,4),List.of(5,3,2));
        System.out.println("\nFlatten nested lists");
        nestedList.stream().flatMap(List::stream).toList().stream().forEach(System.out::print);

        // Concatenate all strings into one
        StringBuilder sb = new StringBuilder();
        for(String s:stringArray){
            sb.append(s);sb.append(" ");
        }
        System.out.println("New string:"+sb.toString().trim());
        //OR
        System.out.println("New string approach2:"+stringArray.stream().reduce(" ",(s1,s2)->s1+" "+s2).trim());
        //OR
        System.out.println("New string approach3:"+stringArray.stream().collect(Collectors.joining(" ")));

        // Find the longest string
        System.out.println("Longest string:"+stringArray.stream().max(Comparator.comparing(String::length)));

        // Remove null values from a list
        List<String> stringArrayWithNull = Arrays.asList("abc","acc",null,"acem",null);
        System.out.println("List without null "+stringArrayWithNull.stream().filter(Objects::nonNull).toList());

        // Calculate the average of integers
        List<Integer> numList = Arrays.asList(1,2,4,5);
        System.out.println(numList.stream().mapToInt(Integer::intValue).average().orElse(0.0));
        //OR
        System.out.println(numList.stream().collect(Collectors.averagingInt(Integer::intValue)));
        //OR
        int sumNum=0;
        for(int i:numList){
            sumNum+=i;
        }
        double avgNum = (double) sumNum/numList.stream().count();
        System.out.println("Avg: "+avgNum);

        // Convert list to map (string → length)
        System.out.println("\nConvert list to map (string → length)");
        System.out.println(stringArray.stream().collect(Collectors.toMap(word->word,String::length)));

        // Find 3rd largest number
        System.out.println("5rd Largest: "+numArray.stream().sorted(Collections.reverseOrder()).skip(4).findFirst());

        // Detect palindromes in a list
        System.out.println("Palindromes: "+stringArray.stream().filter(word->word.equals(new StringBuilder(word).reverse().toString())).toList());

        // Reverse each string in a list
        System.out.println("Reversed: "+stringArray.stream().map(word->new StringBuilder(word).reverse().toString()).toList());

        // Filter map entries with values > 10
        Map<String,Integer> map = Map.of("ABC",10,"DEF",30,"EFG",15);
        System.out.println("Filter values >10 "+map.entrySet().stream().filter(entry->entry.getValue()>10).map(entry->entry.getKey()).toList());

        // Find common elements in two lists
        List<Integer> l1 = List.of(1,4,6,2);
        List<Integer> l2 = List.of(3,4,6,9);

        System.out.println("commons "+l1.stream().filter(i->l2.contains(i)).toList());

        // Sum of squares of even numbers
        List<Integer> l3 = List.of(1,4,6,2);
        System.out.println("sum of squares:"+l3.stream().filter(i->i%2==0).mapToInt(n->n*n).sum());

        // Partition strings into palindromes vs non-palindromes
        System.out.println("Partitioned list:"+stringArray.stream().collect(Collectors.partitioningBy(word->word.equals(new StringBuilder(word).reverse().toString()))));

        // Find the longest word in a sentence
        String inputSentence = "I love java Streams API in java 8";
        System.out.println("Longest String: "+Arrays.stream(inputSentence.split(" ")).max(Comparator.comparing(String::length)).orElse(null));

        // Group strings by first character
        System.out.println("Group by first character:"+stringArray.stream().collect(Collectors.groupingBy(word->word.charAt(0))));

        // Find word with the most vowels
        System.out.println(stringArray.stream().max(Comparator.comparingInt(word->(int)word.chars().filter(i->"aeiou".indexOf(i)!=-1).count())));

        // Calculate the product of numbers
        List<Integer> l = List.of(1,4,6,2);
        System.out.println(l.stream().reduce(1,(a,b)->a*b));

        // Count frequency of characters in a string
        String s = "success";
        System.out.println(s.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(c->c,Collectors.counting())));
    }

}
