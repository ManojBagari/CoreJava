package com.company.Java2_Stream_Operations.JAVA8_STREAM_STATISTICS;

import com.company.Java2_Stream_Operations.Employee;

import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.LongSummaryStatistics;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
/*

        The java.util package contains three classes to collect statistics:

        DoubleSummaryStatistics
        LongSummaryStatistics
        IntSummaryStatistics

        We can use them to compute the summary statistics on any group of numeric data.

*/

        DoubleSummaryStatistics stats = new DoubleSummaryStatistics();
        stats.accept(100.0);
        stats.accept(300.0);
        stats.accept(230.0);
        stats.accept(532.0);
        stats.accept(422.0);

        long count = stats.getCount();
        double sum = stats.getSum();
        double min = stats.getMin();
        double avg = stats.getAverage();
        double max = stats.getMax();

        System.out.printf("count=%d, sum=%.2f,  min=%.2f,  average=%.2f, max=%.2f%n",
                            count, sum, min, max, avg);

/*

        Streams summary statistics

        The summary statistics classes are designed to be used with streams.

        They contain a combine() method that combines two summary statistics.

        The following code shows how to compute the summary statistics for incomes.

*/

        DoubleSummaryStatistics incomeStats = Employee.persons()
                .stream()
                .map(Employee::getIncome)
                .collect(DoubleSummaryStatistics::new,
                        DoubleSummaryStatistics::accept,
                        DoubleSummaryStatistics::combine);
        System.out.println(incomeStats);

/*

        Numeric Stream summary statistics

        The Collectors class contains methods to compute the summary statistics for the specific type of numeric data.

        Collectors.summarizingDouble() returns a DoubleSummaryStatistics.
        Collectors.summarizingLong() returns a LongSummaryStatistics.
        Collectors.summarizingInt() returns a IntSummaryStatistics.

        The Collectors class contains methods such as
        counting(), summingDouble(), summingInt(),
        summingLong(), averagingDouble(), averagingLong(),
        averagingInt(), minBy(), and maxBy()
        that return a collector to perform a specific type of summary computation.

        The following code shows how to calculate the summary statistics for income.

*/

        DoubleSummaryStatistics incomeStats2 = Employee.persons()
                .stream()
                .collect(Collectors.summarizingDouble(Employee::getIncome));
        System.out.println(incomeStats2);













    }



















}
