package com.company.JAVA2_STREAM_OPERATIONS.JAVA3_STREAM_MAP;

import com.company.JAVA2_STREAM_OPERATIONS.Employee;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

/*
   A map operation applies a function to each element to produce another stream.

   The number of elements in the input and output streams is the same.

   The operation does not modify the elements of the input stream.

   You can apply the map operation on a stream using one of the
   following methods of the Stream<T> interface:

<R> Stream<R> map(Function<? super T,? extends R> mapper)
        DoubleStream mapToDouble(ToDoubleFunction<? super T> mapper)
        IntStream mapToInt(ToIntFunction<? super T> mapper)
        LongStream mapToLong(ToLongFunction<? super T> mapper)

        IntStream, LongStream and DoubleStream also define map functions.
        The methods supporting the map operation on an IntStream are as follows:

        IntStream     map(IntUnaryOperator mapper)
        DoubleStream  mapToDouble(IntToDoubleFunction mapper)
        LongStream    mapToLong(IntToLongFunction   mapper)
<U> Stream<U> mapToObj(IntFunction<? extends  U>  mapper)
*/

/*
   The following code shows how to use map()
   to map the elements from IntStream to their squares,
   and prints the mapped stream on the standard output.

*/

        IntStream.rangeClosed(1, 5)
                .map(n -> n * n)
                .forEach(System.out::println);


/*      The following code maps a stream of employees
        to their names and prints the mapped stream.
*/

        Employee.persons()
                .stream()
                .map(Employee::getName)
                .forEach(System.out::println);

/*
        Streams flatMap

        Streams map() operation creates a one-to-one mapping.

           Streams flatMap() supports one-to-many mapping.
           It maps each element to a stream and then flaten
           the stream of streams to a stream.

           The following code maps a stream of three numbers:
           1, 2, and 3 to produce a stream that contains the numbers
           and their next numbers. The output stream should be 1,2,2,3,3,4.

*/

        Stream.of(1, 2, 3)
                .flatMap(n -> Stream.of(n, n+1))
                .forEach(System.out::println);

//        The following code shows how to convert
//        a stream of strings to a stream of characters.

/*
        The code maps the strings to IntStream returns from chars() method
        of the String class.

        The output of the map() method is Stream<IntStream>.

        The flatMap() method maps the Stream<IntStream>
        to Stream<Stream<Character>>
        and finally, flattens it to produce a Stream<Character>.
*/

        Stream.of("XML", "Java",  "CSS")
                .map(name  ->  name.chars())
                .flatMap(intStream ->  intStream.mapToObj(n ->  (char)n))
                .forEach(System.out::println);

//  The following code flatMaps the stream of string values to a IntStreams
//  ,then maps IntStream to Stream of characters.?

        Stream.of("XML", "Java",  "CSS")
                .flatMap(name ->  IntStream.range(0, name.length())
                        .mapToObj(name::charAt))
                .forEach(System.out::println);


        












    }























}














