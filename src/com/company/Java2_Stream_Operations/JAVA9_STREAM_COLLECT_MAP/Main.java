package com.company.Java2_Stream_Operations.JAVA9_STREAM_COLLECT_MAP;

import com.company.Java2_Stream_Operations.Employee;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

/*
        We can collect data from a stream to a Map.

        The toMap() overloaded in three versions method of the
        Collectors class returns a collector to collect data in a Map.

        toMap(Function<? super T,? extends K> keyMapper,
              Function<? super T,? extends U> valueMapper)

        toMap(Function<? super T,? extends K> keyMapper,
              Function<? super T,? extends U> valueMapper,
              BinaryOperator<U> mergeFunction)

        toMap(Function<? super T,? extends K> keyMapper,
              Function<? super T,? extends U> valueMapper,
              BinaryOperator<U> mergeFunction, Supplier<M>  mapSupplier)

        toMap(Function<? super T,? extends K> keyMapper, Function<? super T,? extends U> valueMapper)

        The first version takes two arguments. Both arguments are a Function.
        The first argument maps the stream elements to keys in the map.

        The second argument maps stream elements to values in the map.
        If duplicate keys are found, an IllegalStateException is thrown.

        The following code collects a employee's data in a
        Map<long,String> whose keys are the employee's ids
        and values are employee's names.
*/

        Map<Long,String> idToNameMap  = Employee.persons()
                .stream()
                .collect(Collectors.toMap(Employee::getId,  Employee::getName));
        System.out.println(idToNameMap);

// The second form of toMap listed as follows has an extra merged function.

// toMap(Function<? super T,? extends K> keyMapper,
//       Function<? super T,? extends U> valueMapper,
//       BinaryOperator<U> mergeFunction)

        Map<Employee.Gender,String> genderToNamesMap  =
                Employee.persons()
                        .stream()
                        .collect(Collectors.toMap(Employee::getGender,
                                Employee::getName,
                                (oldValue, newValue)  ->  String.join(", ", oldValue,  newValue)));
        System.out.println(genderToNamesMap);



//        The third version listed as follows allows us to use a Supplier to provide a Map object.

        Map<Employee.Gender, Long> countByGender  = Employee.persons()
                .stream()
                .collect(Collectors.toMap(Employee::getGender, p  ->  1L, (oldCount, newCount)  ->  newCount+oldCount));

        System.out.println(countByGender);

//        The following code get the highest earner by gender in a Map.

        Map<Employee.Gender, Employee>  highestEarnerByGender = Employee.persons()
                .stream()
                .collect(Collectors.toMap(Employee::getGender, Function.identity(),
                        (oldPerson, newPerson)  -> newPerson.getIncome() > oldPerson.getIncome() ? newPerson : oldPerson));
        System.out.println(highestEarnerByGender);

















    }























}

