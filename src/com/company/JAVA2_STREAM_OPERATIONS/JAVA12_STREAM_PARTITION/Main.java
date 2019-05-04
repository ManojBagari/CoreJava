package com.company.JAVA2_STREAM_OPERATIONS.JAVA12_STREAM_PARTITION;

import com.company.JAVA2_STREAM_OPERATIONS.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

/*

Partitioning is a special case of grouping.

Grouping data is based on the keys returned from a function.
There could be many groups.

Partitioning only takes care of two groups based on a predicate.
The value evaluated to true is one group, false is another group.

partitioningBy() method, which collects data in a
Map whose keys are always of the type Boolean, is overloaded in two versions.

partitioningBy(Predicate<? super T> predicate)
partitioningBy(Predicate<? super T> predicate,  Collector<? super T,A,D> downstream)

*/

        Map<Boolean, List<Employee>>  partionedByMaleGender =
                Employee.persons()//  w  w  w. ja v  a 2 s  . c  o m
                        .stream()
                        .collect(Collectors.partitioningBy(Employee::isMale));
        System.out.println(partionedByMaleGender);

 /*
        The second version allows us to specify another collector
        that can perform a reduction operation.

        The following code shows how to partition employee by gender,
        and collects their names in a comma-separated string:
*/

        Map<Boolean,String> partionedByMaleGender2 = Employee.persons()
                .stream()/*from   w  w  w.  jav  a2 s  .  c  o m*/
                .collect(Collectors.partitioningBy(Employee::isMale,
                        Collectors.mapping(Employee::getName, Collectors.joining(", "))));
        System.out.println(partionedByMaleGender2);
















    }










}
