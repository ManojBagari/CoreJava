package com.company.Java2_Stream_Operations.JAVA4_STREAM_REDUCE;

import com.company.Java2_Stream_Operations.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
/*

The reduce() operation combines all elements in a stream to produce a single value.

The reduce operation takes two parameters called a seed (initial value) and an accumulator.
        The accumulator is a function. If the stream is empty, the seed is the result.

The seed and an element are passed to the accumulator,
which returns partial result. And then the partial result
and the next element are passed to the accumulator function.
        This repeats until all elements are passed to the accumulator.
        The last value returned from the accumulator is the result of the reduce operation.

The stream-related interfaces contain two methods called
reduce() and collect() to perform generic reduce operations.
        Methods such as sum(), max(), min(), count(),
        are defined in IntStream, LongStream, and DoubleStream interfaces.

count() method is available for all types of streams.

The Stream<T> interface contains a reduce() method to
perform the reduce operation. The method has three overloaded versions:

T  reduce(T identity, BinaryOperator<T> accumulator)
<U> U reduce(U identity, BiFunction<U,? super  T,U> accumulator, BinaryOperator<U> combiner)
        Optional<T> reduce(BinaryOperator<T> accumulator)


*/

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println(sum);


//        To compute the sum of the incomes of all employee.

        double sum2 = Employee.persons()
                .stream()
                .map(Employee::getIncome)
                .reduce(0.0, Double::sum);
        System.out.println(sum2);

/*

 The second version of the reduce method shown as follows
 allows us to perform a map operation, followed by a reduce operation.

 <U> U reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner)

 The third argument is used
 for combining the partial results when the reduce operation is performed in parallel.

*/
        double sum3 = Employee.persons()
                .stream()
                .reduce(0.0, (partialSum, person) -> partialSum + person.getIncome(), Double::sum);
        System.out.println(sum3);
/*

 Java Stream Map Reduce in parallel

 Java Streams API supports map reduce operations in parallel.

   When using the following reduce method, each thread accumulates
   the partial results using the accumulator.
   At the end, the combiner is used to combine the partial results from all threads to get the result.

   <U> U reduce(U identity, BiFunction<U,? super  T,U> accumulator, BinaryOperator<U> combiner)

*/

        double sum5 = Employee
                .persons()
                .stream()
                .reduce(
                        0.0,
                        (Double partialSum, Employee p) -> {
                            double accumulated = partialSum + p.getIncome();
                            System.out.println(Thread.currentThread().getName()
                                    + "  - Accumulator: partialSum  = " + partialSum
                                    + ",  person = " + p + ", accumulated = " + accumulated);
                            return accumulated;
                        },
                        (a, b) -> {
                            double combined = a + b;
                            System.out.println(Thread.currentThread().getName()
                                    + "  - Combiner:  a  = " + a + ", b  = " + b
                                    + ", combined  = " + combined);
                            return combined;
                        });
        System.out.println("--------------------------------------");
        System.out.println(sum5);

        sum5 = Employee
                .persons()
                .parallelStream()
                .reduce(
                        0.0,
                        (Double partialSum, Employee p) -> {
                            double accumulated = partialSum + p.getIncome();
                            System.out.println(Thread.currentThread().getName()
                                    + "  - Accumulator: partialSum  = " + partialSum
                                    + ",  person = " + p + ", accumulated = " + accumulated);
                            return accumulated;
                        },
                        (a, b) -> {
                            double combined = a + b;
                            System.out.println(Thread.currentThread().getName()
                                    + "  - Combiner:  a  = " + a + ", b  = " + b
                                    + ", combined  = " + combined);
                            return combined;
                        });
        System.out.println(sum5);

/*
        Streams Reduce without default value

        The third version of the reduce() listed as follows
        method is used to perform a reduction operation without default value.

                reduce(BinaryOperator<T> accumulator)

        If the stream is empty, we cannot use default value as 0.

        Optional<T> is used to wrap the result or the absence of a result.
*/

//        The following code shows how to compute the maximum of integers in a stream:

        Optional<Integer> max = Stream.of(1, 2, 3, 4, 5).reduce(Integer::max);

        if (max.isPresent()) {
            System.out.println("max = " + max.get());
        } else {
            System.out.println("max is not  defined.");
        }

        max = Stream.<Integer>empty().reduce(Integer::max);
        if (max.isPresent()) {
            System.out.println("max = " + max.get());
        } else {
            System.out.println("max is not  defined.");
        }

//        The following code prints the details of the highest earner in the employee's list.

        Optional<Employee> person = Employee
                .persons()
                .stream()
                .reduce((p1, p2) -> p1.getIncome() > p2.getIncome() ? p1 : p2);
        if (person.isPresent()) {
            System.out.println("Highest earner: " + person.get());
        } else {
            System.out.println("Could not  get   the   highest earner.");
        }


    }


}
