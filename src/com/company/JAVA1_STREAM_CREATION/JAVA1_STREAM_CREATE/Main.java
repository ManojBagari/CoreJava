package com.company.JAVA1_STREAM_CREATION.JAVA1_STREAM_CREATE;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {

		// We can use of() from Stream interface to create a sequential Stream from a
		// single value and multiple values .
		// <T> Stream<T> of(T t)
		// <T> Stream<T> of(T...values)

		// stream which contains a single value.
		Stream<String> stream = Stream.of("java2s.com");
		stream.forEach(System.out::println);

		// stream which contains a four value.
		Stream<String> stream2 = Stream.of("XML", "Java", "CSS", "SQL");
		stream2.forEach(System.out::println);

		// stream from an array of objects.
		String[] names = { "XML", "Java", "SQL", "CSS" };
		Stream<String> stream3 = Stream.of(names);
		stream3.forEach(System.out::println);

		// They can also be created out of an existing array or of a part of an array:
		String[] arr = new String[] { "a", "b", "c" };
		Stream<String> streamOfArrayFull = Arrays.stream(arr);
		Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);

		// We can use Stream.Builder<T> to create streams
		Stream<String> stream4 = Stream.<String>builder().add("XML").add("Java").add("CSS").add("SQL").build();
		stream4.forEach(System.out::println);

//         We can use the following two methods from IntStream interfaces to create IntStream from a range of int values.

//          IntStream range(int start, int end)
//          IntStream rangeClosed(int start, int end).

//          They create an IntStream that contains ordered integers between the start and end;
//          The specified end is exclusive in the range() method and inclusive in the rangeClosed() method.

		IntStream oneToFive = IntStream.range(1, 6);
		// IntStream oneToFive = IntStream.rangeClosed(1, 5);
		oneToFive.forEach(System.out::println);

//        Like the IntStream interface, the LongStream class also contains range() and rangeClosed() methods
//        that takes arguments of type long and return a LongStream.

//        Empty Streams
//        An empty stream has no elements.
//        We can use empty() static method from Stream interface to create an empty sequential stream.

		Stream<String> stream5 = Stream.empty();
		stream5.forEach(System.out::println);

//        The IntStream, LongStream, and DoubleStream interfaces
//        also contain an empty() static method to create an empty stream of primitive types.

//        The following code creates an empty stream of integers.
//                IntStream numbers = IntStream.empty();

//        The following code creates an empty stream of integers.
//                IntStream numbers = IntStream.empty();

	}
}