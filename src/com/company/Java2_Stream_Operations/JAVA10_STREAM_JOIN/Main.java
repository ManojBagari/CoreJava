package com.company.Java2_Stream_Operations.JAVA10_STREAM_JOIN;

import com.company.Java2_Stream_Operations.Employee;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

/*

        The joining() method from Collectors class returns
        a collector that concatenates the stream of CharSequence
        and returns the result as a String.

        The joining() method is overloaded and it has three versions:

        joining()
        concatenates all elements
        joining(CharSequence delimiter)

        uses a delimiter to be used between two elements.
        joining(CharSequence delimiter, CharSequence prefix, CharSequence suffix)

        uses a delimiter, a prefix and a suffix. The prefix is added to the beginning and the suffix is added to the end.

                The following code shows how to use the joining() method.


*/

        List<Employee> persons  = Employee.persons();
        String names = persons.stream()
                .map(Employee::getName)
                .collect(Collectors.joining());

        String  delimitedNames = persons.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(", "));

        String  prefixedNames = persons.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(", ", "Hello ",  ".  Goodbye."));

        System.out.println("Joined names:  "  + names);
        System.out.println("Joined,  delimited names:  "  + delimitedNames);
        System.out.println(prefixedNames);














    }

}
