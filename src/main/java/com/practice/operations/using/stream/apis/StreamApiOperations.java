package com.practice.operations.using.stream.apis;

import org.apache.logging.log4j.util.PropertySource;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;



public class StreamApiOperations {

    public void sumOfArrayList(List<Integer> numbers){
        int sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println("The sum of numbers in a given list is: " +sum);
    }

    public void averageOfList(List<Integer> numbers){
        double avg = numbers.stream().mapToInt(e -> e).average().getAsDouble();
        System.out.println("The average of numbers in a given list is: " +avg);
    }

    public void squareFilter(List<Integer> numbers){
        double avg = numbers.stream()
                            .map(e -> e*e)
                            .filter(e -> e>20)
                            .mapToInt(e -> e)
                            .average().getAsDouble();

        System.out.println("The average of squares of numbers which are greater than 25 is: " +avg);
    }

    public void listOfEvenOdd(List<Integer> numbers){
        List<Integer> evenList = numbers.stream()
                                        .filter(e -> e%2==0)
                                        .collect(Collectors.toUnmodifiableList());
        List<Integer> oddList = numbers.stream()
                                       .filter(e -> e%2!=0)
                                       .collect(Collectors.toUnmodifiableList());
        System.out.println("The even numbers in a given list is: " +evenList);
        System.out.println("The odd numbers in a given list is: " +oddList);
    }

    public void numWithOne(List<Integer> numbers){
        List<Integer> numberWith1 = numbers.stream()
                                           .map(String::valueOf)
                                           .filter(e -> e.startsWith("1"))
                                           .map(Integer::valueOf)
                                           .collect(Collectors.toUnmodifiableList());

        System.out.println("List of numbers starting with number 1 is: " +numberWith1);
    }

    public void duplicateNumbers(List<Integer> numbers){
        Set<Integer> duplicateSet = numbers.stream()
                                           .filter(e -> Collections.frequency(numbers, e) > 1)
                                           .collect(Collectors.toUnmodifiableSet());
        Set<Integer> noDuplicateSet = numbers.stream()
                                             .filter(e -> !duplicateSet.contains(e))
                                             .collect(Collectors.toUnmodifiableSet());

        System.out.println("The duplicate numbers in a given list is: " +duplicateSet);
        System.out.println("The no duplicate numbers in a given list is: " +noDuplicateSet);
    }

    public void findMaxMin(List<Integer> numbers){
        int max = numbers.stream().max(Comparator.comparing(Integer::intValue)).get();
        System.out.println("The max number in a given list is: " +max);

        int min = numbers.stream().min(Comparator.comparing(Integer::intValue)).get();
        System.out.println("The min number in a given list is: " +min);
    }

    public void sortedList(List<Integer> numbers){
        List<Integer> ascList = numbers.stream().sorted().collect(Collectors.toUnmodifiableList());
        System.out.println("The sorted numbers in a given list in ASC order: " +ascList);
        List<Integer> dscList = numbers.stream().sorted(Collections.reverseOrder()).collect(Collectors.toUnmodifiableList());
        System.out.println("The sorted numbers in a given list in DESC order: " +dscList);
    }

    public void getSkip(List<Integer> numbers){
        List<Integer> getList = numbers.stream().limit(5).collect(Collectors.toList());
        System.out.println("The first 5 numbers in a given list is: " +getList);

        List<Integer> skipList = numbers.stream().skip(5).collect(Collectors.toList());
        System.out.println("After skipping first 5 numbers in a given list is: " +skipList);
    }

    public void secHighestLowest(List<Integer> numbers){
        int secHighest = numbers.stream().sorted(Comparator.reverseOrder()).limit(2).min(Comparator.comparing(Integer::intValue)).get();
        int secLowest = numbers.stream().sorted().limit(2).max(Comparator.comparing(Integer::intValue)).get();
        System.out.println("The secHighest number in a given list is: " +secHighest);
        System.out.println("The secLowest number in a given list is: " +secLowest);
    }

    public void stringCharCount() {
        String str = "Manohar Reddy Chiluka";
        str = str.toLowerCase();
        Map<String, Long> map = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);
    }
    public void duplicateChar(){
        String str = "Sai Yashwanth Reddy Gujjula";
        str = str.toLowerCase();
        List<String> duplicateList = Arrays.stream(str.split("")).toList();
        System.out.println(duplicateList.stream()
                .filter(e -> Collections.frequency(duplicateList, e) > 1)
                .collect(Collectors.toUnmodifiableSet()));
        }
}
