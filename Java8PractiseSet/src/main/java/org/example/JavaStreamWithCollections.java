package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class JavaStreamWithCollections {

    public static void main(String args []){

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> nums = numbers.stream()
                .filter(x -> x %2 == 0)
                .collect(Collectors.toList());
        System.out.println(nums);

        //print number start with prefix 2

        List<Integer> num = Arrays.asList(1, 2, 22, 56, 234, 222, 789, 90, 29, 20);

        num.stream().map(x -> String.valueOf(x))
                .filter(x -> x.startsWith("2"))
                .map(Integer :: valueOf)
                .collect(Collectors.toList())
                .forEach(System.out :: println);

        //find duplicate numbers

        List<Integer> duplicateNum = Arrays.asList(1, 5,6,5,77,21,20,1,9,6,77,45,32);
        duplicateNum.stream().filter( e -> Collections.frequency(duplicateNum, e)>1)
                .collect(Collectors.toSet()).forEach(System.out :: println);

        Set<Integer> hashSet = new HashSet<>();
        duplicateNum.stream().filter(e -> !hashSet.add(e)).collect(Collectors.toList())
                .forEach(System.out :: println);



        int res = num.stream().reduce(Integer.MIN_VALUE, (a, b) -> a > b ? a: b);
        System.out.println(res);

        duplicateNum.stream().sorted().collect(Collectors.toList()).forEach(System.out :: println);
        List<Integer> dupData = duplicateNum.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        System.out.println(dupData);

        //ignore first 5 numbers

        List<Integer> l = numbers.stream().limit(5).collect(Collectors.toList());
        System.out.println(l);

        int sum = numbers.stream().limit(5).reduce((p,q)->p+q).get();
        System.out.println(sum);

        //skip 5 numbers

        List<Integer> skipNums = numbers.stream().skip(5).collect(Collectors.toList());
        System.out.println(skipNums);


        int secHighest = duplicateNum.stream().sorted(Collections.reverseOrder())
                .distinct().skip(1).findFirst().get();

        System.out.println(secHighest);

        int secLowest = duplicateNum.stream().sorted().distinct().skip(1).findFirst().get();
        System.out.println(secLowest);














    }
}
