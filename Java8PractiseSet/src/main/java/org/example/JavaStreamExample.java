package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class JavaStreamExample {

    public static void main(String args[]){
        List<Integer> listOfNumbers = Arrays.asList(1,6,7,5,3,2);

        int sum = listOfNumbers.stream().reduce(0, (a,b) -> a+b);
        System.out.println(sum);

        //second way

        Optional<Integer> secondSum = listOfNumbers.stream().reduce((a, b) -> a+b );

        secondSum.ifPresent(s -> System.out.println("Sum: " + s));

        //Finding the Maximum Value

        Optional<Integer> maxVal = listOfNumbers.stream().reduce( (a,b) -> a > b ? a : b);
        if (maxVal.isPresent()) {
            System.out.println("Max: " + maxVal.get());  // Output: Max: 5
        } else {
            System.out.println("List is empty");
        }

        //Option 2

        int max = listOfNumbers.stream().reduce(Integer.MIN_VALUE, (a,b)-> a > b ? a : b);
        System.out.println("Max: " + max);

        //Concatenating Strings

        List<String> words = Arrays.asList("Java", "SpringBoot", "Geeks");
        String str = words.stream().reduce("", (a, b) -> a + b);
        System.out.println("Concatenated String: " + str);

        //Parallel Streams

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int parallelSum = numbers.parallelStream().reduce(0, (a,b)-> a+b, (a, b) -> a +b);
        System.out.println("Sum: " + parallelSum);

        // Convert each string to its length and sum them

        List<String> wordsLength = Arrays.asList("Java", "Stream", "mapToInt");
        int length = wordsLength.stream().mapToInt(String::length).sum();
        System.out.println("Length: " + length);

        // // Find the maximum and Minimum, Average value

        List<Integer> num = Arrays.asList(5, 10, 15, 20, 25);

        int maxValResult = num.stream().mapToInt(Integer :: intValue)
                .max().orElseThrow(() -> new RuntimeException("No max value found"));
        System.out.println("maxValResult: " + maxValResult);

        int minValResult = num.stream().mapToInt(Integer :: intValue)
                .min().orElseThrow(() -> new RuntimeException("No Min Value Found"));
        System.out.println("minValResult: " + minValResult);

        double avg = num.stream().mapToInt(Integer::intValue)
                .average().getAsDouble();
        System.out.println("Average: " + avg);

        //Sum of even numbers

        List<Integer> numData = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int evenSum = numData.stream().mapToInt(Integer::intValue)
                .filter(y -> y %2 ==0)
                .sum();

        numData.stream().mapToInt(Integer::intValue)
                .filter(y -> y %2 ==0)
                        .forEach(System.out :: println);
        System.out.println("evenSum: " + evenSum);


        int oddSum = numData.stream().mapToInt(Integer::intValue)
                .filter(x -> x% 2 !=0)
                .sum();
        System.out.println("oddSum: " + oddSum);


        // Get distinct lengths of words

        List<String> disWords = Arrays.asList("apple", "banana", "pear", "kiwi", "grape");
        disWords.stream().mapToInt(String :: length).distinct().forEach(System.out :: println);

        //Square of each number

        List<Integer> numDataSquare = Arrays.asList(1, 2, 3, 4, 5, 6);
        numDataSquare.stream().map( x -> x*x)
                .filter(x -> x <35)
                .mapToInt( x -> x)
                .forEach(System.out :: println);




















    }


}
