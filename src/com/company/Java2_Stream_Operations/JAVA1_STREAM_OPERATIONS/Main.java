package com.company.Java2_Stream_Operations.JAVA1_STREAM_OPERATIONS;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {


        /*
    The commonly used stream operations are listed as follows.

    Distinct
    Intermediate Operation
    Returns a stream consisting of the distinct elements by checking equals() method.

    filter
    Intermediate Operation
    Returns a stream that match the specified predicate.

    flatMap
    Intermediate Operation
    Produces a stream flattened.

    limit
    Intermediate Operation
    truncates a stream by number.

    map
    Intermediate Operation
    Performs one-to-one mapping on the stream

    peek
    Intermediate Operation
    Applies the action for debugging.

    skip
    Intermediate Operation
    Discards the first n elements and returns the remaining stream.
    If this stream contains fewer than requested, an empty stream is returned.

    sorted
    Intermediate Operation
    Sort a stream according to natural order or the specified Comparator.
    For an ordered stream, the sort is stable.








    allMatch
    Terminal Operation
    Returns true if all elements in the stream match the specified predicate,
    false otherwise. Returns true if the stream is empty.

    anyMatch
    Terminal Operation
    Returns true if any element in the stream matches the specified predicate,
    false otherwise. Returns false if the stream is empty.

    findAny
    Terminal Operation
    Returns any element from the stream. Returns an empty Optional object for an empty stream.

    findFirst
    Terminal Operation
    Returns the first element of the stream. For an ordered stream,
    it returns the first element; for an unordered stream, it returns any element.

    noneMatch
    Terminal Operation
    Returns true if no elements in the stream match the specified predicate,
    false otherwise. Returns true if the stream is empty.

    forEach
    Terminal Operation
    Applies an action for each element in the stream.

    reduce
    Terminal Operation
    Applies a reduction operation to computes a single value from the stream.

*/

/*

    Streams Peek

    We can debug a stream by using the

    peek(Consumer<? super T> action) method of the Stream<T> interface.

    The IntStream, LongStream, and DoubleStream also contain a peek()
    method that takes a IntConsumer, a LongConsumer, and a DoubleConsumer as an argument.

    We can use a lambda expression with the peek() method to log elements.

    The following code uses the peek() method to print the elements passing through the stream pipeline:

*/


        int sum = Stream.of(1, 2, 3, 4, 5)
                .peek(e -> System.out.println("Taking integer: " + e))
                .filter(n -> n % 2 == 1)
                .peek(e -> System.out.println("Filtered integer: " + e))
                .map(n -> n * n).peek(e -> System.out.println("Mapped integer: " + e))
                .reduce(0, Integer::sum);
        System.out.println("Sum = " + sum);

/*
        Streams ForEach

        The forEach operation takes an action for each element of the stream.

        The Stream<T> interface contains two methods to perform the forEach operation:

        void  forEach(Consumer<? super  T> action)
        void  forEachOrdered(Consumer<? super  T> action)

        IntStream, LongStream, and DoubleStream contain the same methods.

         The forEach() method does not guarantee the order in which the action for each element in the stream is applied.

         The forEachOrdered() method performs the action in the order of elements defined by the stream.

         forEachOrdered() method may slow down processing in a parallel stream.

         The following code prints the details of females in the employee list:
*/


        Employee.persons()
                .stream()
                .filter(Employee::isFemale)
                .forEach(System.out::println);


//        The following code shows how to use the forEach() method to increase the income of all females by 10%.

        List<Employee> persons = Employee.persons();
        System.out.println("Before increasing the   income:   " + persons);

        persons.stream()
                .filter(Employee::isFemale)
                .forEach(p -> p.setIncome(p.getIncome() * 1.10));

        System.out.println("After increasing the   income:   " + persons);

    }


}


class Employee {
    public static enum Gender {
        MALE, FEMALE
    }

    private long id;
    private String name;
    private Gender gender;
    private LocalDate dob;
    private double income;

    public Employee(long id, String name, Gender gender, LocalDate dob,
                    double income) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.income = income;
    }

    public Gender getGender() {
        return gender;
    }

    public boolean isMale() {
        return this.gender == Gender.MALE;
    }

    public boolean isFemale() {
        return this.gender == Gender.FEMALE;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public static List<Employee> persons() {
        Employee p1 = new Employee(1, "Jake", Gender.MALE, LocalDate.of(1971,
                Month.JANUARY, 1), 2343.0);
        Employee p2 = new Employee(2, "Jack", Gender.MALE, LocalDate.of(1972,
                Month.JULY, 21), 7100.0);
        Employee p3 = new Employee(3, "Jane", Gender.FEMALE, LocalDate.of(1973,
                Month.MAY, 29), 5455.0);
        Employee p4 = new Employee(4, "Jode", Gender.MALE, LocalDate.of(1974,
                Month.OCTOBER, 16), 1800.0);
        Employee p5 = new Employee(5, "Jeny", Gender.FEMALE, LocalDate.of(1975,
                Month.DECEMBER, 13), 1234.0);
        Employee p6 = new Employee(6, "Jason", Gender.MALE, LocalDate.of(1976,
                Month.JUNE, 9), 3211.0);

        List<Employee> persons = Arrays.asList(p1, p2, p3, p4, p5, p6);

        return persons;
    }
}