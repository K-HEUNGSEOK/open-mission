package stream.collectors;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsMap {
    public static void main(String[] args) {
        Map<String, Integer> map1 = Stream.of("Apple", "Banana", "Tomato")
                .collect(Collectors.toMap(
                        name -> name, //key
                        String::length));//value

        System.out.println("map1 = " + map1);

        //키가 중복되면 예외 발생
//        Map<String, Integer> map2 = Stream.of("Apple","Apple", "Banana", "Tomato")
//                .collect(Collectors.toMap(
//                        name -> name, //key
//                        String::length));//value
//
//        System.out.println("map2 = " + map2);

        Map<String, Integer> map3 = Stream.of("Apple","Apple", "Banana", "Tomato")
                        .collect(Collectors.toMap(
                                name -> name,
                                String::length,
                                (oldVal,newVal) -> oldVal+newVal //중복될 경우 기존 값 + 새값
                        ));
        System.out.println("map3 = " + map3);

        //map 의 타입 지정
        Map<String, Integer> map4 = Stream.of("Apple","Apple", "Banana", "Tomato")
                .collect(Collectors.toMap(
                        name -> name,
                        String::length,
                        (oldVal,newVal) -> oldVal+newVal, //중복될 경우 기존 값 + 새값
                        LinkedHashMap::new
                ));
        System.out.println("map4 = " + map4);
    }
}
