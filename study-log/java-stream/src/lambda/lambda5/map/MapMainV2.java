package lambda.lambda5.map;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import lambda.lambda5.filter.GenericFilter;

public class MapMainV2 {
    public static void main(String[] args) {
        List<String> fruits = List.of("apple", "banana", "orange");
        List<String> upperList = GenericMap.mapper(fruits, String::toUpperCase);
        System.out.println("upperList = " + upperList);

        List<Integer> lengthList = GenericMap.mapper(fruits, String::length);
        System.out.println("lengthList = " + lengthList);

        List<Integer> list = List.of(1,2,3);
        List<String> mapper = GenericMap.mapper(list, n -> "*".repeat(n));
        System.out.println("mapper = " + mapper);
    }

}
