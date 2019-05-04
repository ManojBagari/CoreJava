package com.company.Java2_Stream_Operations.JAVA6_STREAM_COUNT;

import com.company.Java2_Stream_Operations.Employee;

public class Main {
    public static void main(String[] args) {

//        Streams support a count operation through the
//        count() method that returns the number of elements
//        in the stream as a long.

//        The following code prints the number of elements in the stream of employee.

        long personCount = Employee.persons().stream().count();
        System.out.println("Person count: " + personCount);

//        The following code uses the map() method to count the number of elements in a stream.

        long  personCount2 = Employee.persons()
                .stream()
                .mapToLong(p ->  1L)
                .sum();
        System.out.println(personCount2);

//        The following code uses the map() and reduce() methods to implement the count operation.

        long  personCount3 = Employee.persons()
                .stream()
                .map(p  ->  1L)
                .reduce(0L,  Long::sum);
        System.out.println(personCount3);

//        The following code uses the reduce() method to implement the count ope

        long  personCount4 = Employee.persons()
                .stream()
                .reduce(0L, (partialCount,  person) ->  partialCount + 1L,  Long::sum);
        System.out.println(personCount4);











    }

}
