package com.company.JAVA2_STREAM_OPERATIONS.JAVA7_STREAM_COLLECTORS;

import com.company.JAVA2_STREAM_OPERATIONS.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

   /*   To group data in a Stream we can use collect() method of the Stream<T> interface.

        The collect() method is overloaded with two versions:

<R> R collect(Supplier<R> supplier, BiConsumer<R,? super T> accumulator, BiConsumer<R,R> combiner)
<R,A> R collect(Collector<?  super T,A,R> collector)

        The first version of the collect() method takes three arguments:

        A supplier that supplies a mutable container to store the results.
                An accumulator that accumulates the results into the mutable container.
                A combiner that combines the partial results when used in parallel.

        We use the following steps to collect the employee names in an ArrayList<String>.

                First, create a supplier which returns an ArrayList<String> using either of the following statements to create the supplier:
        Supplier<ArrayList<String>> supplier = () -> new ArrayList<>();

        or
        Supplier<ArrayList<String>> supplier = ArrayList::new;

        Second, create an accumulator that receives two arguments which is the container returned from the supplier(ArrayList<String> in this case). and the element of the stream.

        The accumulator adds the names to the list.

        BiConsumer<ArrayList<String>, String> accumulator = (list, name)  ->  list.add(name);
        BiConsumer<ArrayList<String>, String>  accumulator = ArrayList::add;

        Finally, a combiner combines the results into one ArrayList<String>.

                The combiner is used only in a parallel stream

*/


//        The following code shows how to use the collect() method to collect the names of all employee in a list.


        List<String> names = Employee.persons()
                .stream()
                .map(Employee::getName)
                .collect(ArrayList::new,  ArrayList::add, ArrayList::addAll);
        System.out.println(names);

/*

        Collector interface

        The second version of the collect() takes an instance of the Collector interface as an argument.

        Streams API provides a utility class called Collectors that provides out-of-box implementations for commonly used collectors.

                Three of the most commonly used methods of the Collectors class are toList(), toSet(), and toCollection().

                The toList() method returns a Collector that collects the data in a List.
                The toSet() method returns a Collector that collects data in a Set.
        The toCollecton() takes a Supplier that returns a Collection to be used to collect data.

*/

        List<String> names2 = Employee.persons()
                .stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println(names2);



//        The following code collects all names in a Set<String> which keeps only unique elements.

        Set<String> uniqueNames  = Employee.persons()
                .stream()
                .map(Employee::getName)
                .collect(Collectors.toSet());
        System.out.println(uniqueNames);

//        We can collect names in a sorted set using the toCollection() method as follows:


        SortedSet<String> uniqueSortedNames=   Employee.persons()
                .stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(uniqueSortedNames);
        System.out.println(uniqueSortedNames);



























    }


}
