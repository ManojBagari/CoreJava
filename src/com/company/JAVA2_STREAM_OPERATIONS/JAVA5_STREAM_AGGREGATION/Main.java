package com.company.JAVA2_STREAM_OPERATIONS.JAVA5_STREAM_AGGREGATION;

import com.company.JAVA2_STREAM_OPERATIONS.Employee;

import java.util.Comparator;
import java.util.Optional;
import java.util.OptionalDouble;

public class Main {
    public static void main(String[] args) {


/*
        To compute the sum, max, min, average, etc. on a numeric stream,
        we can map the non-numeric stream into numeric stream types (IntStream, LongStream, or DoubleStream)
        and then use the specialized methods.

        The following code calculates the sum of the incomes.
        mapToDouble() method converts a Stream<Employee> to a DoubleStream.
        The sum() method is called on the DoubleStream
*/

        double totalIncome = Employee.persons()
                .stream()
                .mapToDouble(Employee::getIncome)
                .sum();
        System.out.println("Total Income:  " + totalIncome);


//    To get the minimum and maximum values of a stream,
//    use the min() and max() methods of the specific stream.

        Optional<Employee> person = Employee.persons().stream()
                .max(Comparator.comparingDouble(Employee::getIncome));

        if (person.isPresent()) {
            System.out.println("Highest earner: " + person.get());
        } else {
            System.out.println("Could not  get   the   highest earner.");
        }
    }

//    The following code prints the highest income
//    in the employee list using the max() method of the DoubleStream:


    OptionalDouble income =
            Employee.persons()
                    .stream()
                    .mapToDouble(Employee::getIncome).max();



if(income.isPresent())

    {
        System.out.println("Highest income:   " + income.getAsDouble());
    } else{
        System.out.println("Could not  get   the   highest income.");
    }


}


