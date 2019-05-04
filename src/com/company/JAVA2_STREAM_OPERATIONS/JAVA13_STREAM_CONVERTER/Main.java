package com.company.JAVA2_STREAM_OPERATIONS.JAVA13_STREAM_CONVERTER;

import com.company.JAVA2_STREAM_OPERATIONS.Employee;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

/*
        We can convert the result of the collector to a different type.

        collectingAndThen() method of the Collectors class is defined as follows.

        collectingAndThen(Collector<T,A,R> downstream, Function<R,RR>  finisher)
        The first argument is a collector that collects the data.
        The second argument is a finisher which converts the result.

*/

        List<String> names = Employee.persons()
                .stream()
                .map(Employee::getName)
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        result ->  Collections.unmodifiableList(result)));
        System.out.println(names);












    }
}
