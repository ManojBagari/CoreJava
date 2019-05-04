package com.company.JAVA3_PARAllEL_STREAMS;

import com.company.JAVA2_STREAM_OPERATIONS.Employee;

import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
/*
        Streams can be sequential or parallel.

        Operations on a sequential stream are
        processed in serial by one thread.

        Operations on a parallel stream are
        processed in parallel using multiple threads.

        Most of the methods in the Streams API produce
        sequential streams by default.
        To create a parallel stream from a collection
        such as a List or a Set,
        call the parallelStream() method of the Collection interface.

        Use the parallel() method on a stream to convert
        a sequential stream into a parallel stream.

        Use the sequential() method on a stream to convert
        a parallel stream into a sequential stream.
*/
        String names = Employee.persons()
                .stream()
                .filter(Employee::isMale)
                .map(Employee::getName)
                .collect(Collectors.joining(", "));
        System.out.println(names);

        names = Employee.persons()
                .parallelStream()
                .filter(Employee::isMale)
                .map(Employee::getName)
                .collect(Collectors.joining(", "));
        System.out.println(names);

//        The following code shows how to mix serial and parallel streams:

        String names2 = Employee.persons()                // The data source
                .stream()                  // Produces a  sequential  stream
                .filter(Employee::isMale)   // Processed in serial
                .parallel()               // Produces a  parallel  stream
                .map(Employee::getName)       // Processed in parallel
                .collect(Collectors.joining(", "));  // Processed in parallel
        System.out.println(names2);







    }


}
