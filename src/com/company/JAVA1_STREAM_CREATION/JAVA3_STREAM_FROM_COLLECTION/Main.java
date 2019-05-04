package com.company.JAVA1_STREAM_CREATION.JAVA3_STREAM_FROM_COLLECTION;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

/*

        Streams from Arrays

        java.util.Arrays class contains stream() method to create sequential streams from arrays.

        We can use it to create an IntStream, a LongStream, a DoubleStream, and a Stream<T>.

        The following code creates an IntStream.
        IntStream numbers = Arrays.stream(new int[]{1, 2, 3});

        The following code creates a Stream<String> from an int array and a String array.
*/


        Stream<String> names = Arrays.stream(new String[] {"XML",   "Java"});


/*

        Streams from Collections

        The Collection interface contains the stream() and parallelStream() methods
        that create sequential and parallel streams from a Collection, respectively.

        The following code creates streams from a set of strings:
*/

        Set<String> names = new HashSet<>();
        names.add("XML");
        names.add("Java");

        Stream<String> sequentialStream  = names.stream();
        sequentialStream.forEach(System.out::println);

        Stream<String> parallelStream = names.parallelStream();
        parallelStream.forEach(System.out::println);

        







    }




}
