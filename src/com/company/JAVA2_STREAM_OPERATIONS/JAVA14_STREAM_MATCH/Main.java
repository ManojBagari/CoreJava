package com.company.JAVA2_STREAM_OPERATIONS.JAVA14_STREAM_MATCH;

import com.company.JAVA2_STREAM_OPERATIONS.Employee;

import java.util.List;
import java.util.stream.DoubleStream;

public class Main {

    public static void main(String[] args) {

/*
        The Streams API supports different types of match operations on stream elements.

        The following methods in the Stream interface are used to perform match operations:

        boolean allMatch(Predicate<? super T> predicate)
        boolean anyMatch(Predicate<? super T> predicate)
        boolean noneMatch(Predicate<? super  T> predicate)

        The primitive type streams such as
        IntStream, LongStream, and DoubleStream
        also contain the same methods that work
        with a predicate and an optional one for primitive types.

        All match operations are terminal operations.
        They are also short-circuiting operations.
        A short-circuiting operation may not have
        to process the entire stream to return the result.

        The following code shows how to perform match operations on streams.

*/

        List<Employee> persons = Employee.persons();

        // Check if all persons are males
        boolean allMales = persons.stream().allMatch(Employee::isMale);
        System.out.println("All  males: " + allMales);

        // Check if any person was born in 1971
        boolean anyoneBornIn1971 = persons.stream().anyMatch(p -> p.getDob().getYear() == 1971);
        System.out.println("Anyone born  in 1971:  " + anyoneBornIn1971);













    }
}
