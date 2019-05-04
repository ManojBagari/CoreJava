package com.company.JAVA2_STREAM_OPERATIONS.JAVA11_STREAM_GROUP;

import com.company.JAVA2_STREAM_OPERATIONS.Employee;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

/*

        The groupingBy() method from the Collectors class returns
        a collector that groups the data before collecting them in a Map.
        It is similar to a "group by" clause in SQL.

        The groupingBy() method is overloaded and it has three versions:

        groupingBy(Function<? super  T,?  extends K>  classifier)
        groupingBy(Function<? super  T,?  extends K>  classifier
                   ,Collector<? super T,A,D> downstream)
        groupingBy(Function<? super  T,?  extends K>  classifier
                   ,Supplier<M>  mapFactory
                   ,Collector<? super T,A,D> downstream)

        In the first two versions, the collector takes care of creating the Map object for you.
        The third version allows us to specify a Supplier used as the factory to get the Map object.

        classifier function generates the keys in the map.
        collector performs a reduction operation on the values associated with each key.

        The following code shows how to group people by gender and
        count the number of people in each group.

        The counting() method of the Collectors class returns a
        Collector to count the number of elements in a stream.

*/

        Map<Employee.Gender, Long> countByGender  = Employee.persons()
                .stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(countByGender);


//        The following code shows how to group the names of person by gender:

        Map<Employee.Gender, String>  namesByGender = Employee.persons()
                .stream()
                .collect(Collectors.groupingBy(Employee::getGender,
                        Collectors.mapping(Employee::getName, Collectors.joining(", "))));
        System.out.println(namesByGender);


//        The following code shows how to collect the employee names in a List.

        Map<Employee.Gender, List<String>>  namesByGender2 =
                Employee.persons()
                        .stream()
                        .collect(Collectors.groupingBy(Employee::getGender,
                                Collectors.mapping(Employee::getName, Collectors.toList())));

        System.out.println(namesByGender2);

/*
        The following code groups people by gender.
        Within each gender group,
        it creates another group based
        on the month of their births
        and lists the names of the people born in this group.
*/

        Map personsByGenderAndDobMonth
                = Employee.persons()
                .stream()
                .collect(Collectors.groupingBy(Employee::getGender,
                        Collectors.groupingBy(p ->  p.getDob().getMonth(),
                                Collectors.mapping(Employee::getName,Collectors.joining(", ")))));

        System.out.println(personsByGenderAndDobMonth);

//        The following code shows how to summarize Statistics of income grouped by gender.

        Map<Employee.Gender, DoubleSummaryStatistics>  incomeStatsByGender = Employee.persons()
                .stream()//from  w  w  w . ja  v a 2  s  .c om
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.summarizingDouble(Employee::getIncome)));

        System.out.println(incomeStatsByGender);







    }


















}
