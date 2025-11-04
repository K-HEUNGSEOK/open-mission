package lambda.lambda5.map;
import java.util.*;
import java.util.function.Function;

public class MapMainV1 {
    public static void main(String[] args) {
        List<String> list = List.of("1", "12", "123", "1234");
        List<Integer> integerList = StringToIntegerMap.mapper(list, Integer::parseInt);
        System.out.println(integerList);

        List<Integer> integerList2 = StringToIntegerMap.mapper(list, String::length);
        System.out.println(integerList2);

    }

    static List<Integer> mapStringToInteger(List<String> list, Function<String,Integer> function){
        List<Integer> newList = new ArrayList<>();
        for (String s : list) {
            newList.add(function.apply(s));
        }
        return newList;
    }
}
