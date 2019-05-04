package com.company.Java2_Stream_Operations.JAVA2_STREAM_FILTER;

import com.company.Java2_Stream_Operations.Employee;

public class Main {
    public static void main(String[] args) {


/*
   The filter operation produces a filtered stream,
   a subset of the input stream, whose elements evaluate to true for the specified predicate.

   A predicate is a function that accepts an element and returns a boolean value.

   The filtered stream has the same type as the input stream.

   If the predicate evaluates to false for all elements, it produces an empty stream.
*/


/*
  The following code uses a stream of employees and filters in only females.
  It maps the females to their names and prints them on the standard output.
*/

        Employee.persons()
                .stream()
                .filter(Employee::isFemale)
                .map(Employee::getName)
                .forEach(System.out::println);

//        For the following code



        Employee.persons()
                .stream()
                .filter(Employee::isMale)
                .filter(p ->  p.getIncome() > 5000.0)
                .map(Employee::getName)
                .forEach(System.out::println);

//        We can combine the two filters to one with AND operation.

        Employee.persons()
                .stream()
                .filter(p ->  p.isMale() &&   p.getIncome() > 5000.0)
                .map(Employee::getName)
                .forEach(System.out::println);











    }


}
