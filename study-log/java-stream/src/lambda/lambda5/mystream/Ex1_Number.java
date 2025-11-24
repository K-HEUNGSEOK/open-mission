package lambda.lambda5.mystream;

import java.util.ArrayList;
import java.util.List;
import lambda.lambda5.filter.GenericFilter;
import lambda.lambda5.map.GenericMap;

public class Ex1_Number {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3,4,5,6,7,8,9,10);
        List<Integer> direct = direct(list);
        System.out.println("direct = " + direct);

        List<Integer> mapper = lambda(list);
        System.out.println("mapper = " + mapper);

    }

    private static List<Integer> lambda(List<Integer> list) {
        List<Integer> filter = GenericFilter.filter(list, n -> n % 2 == 0);
        List<Integer> mapper = GenericMap.mapper(filter, n -> n * 2);
        return mapper;
    }

    static List<Integer> direct(List<Integer> list){
        List<Integer> newList = new ArrayList<>();
        for (Integer i : list) {
            if(i % 2 == 0){
                newList.add(i * 2);
            }
        }
        return newList;
    }
}
