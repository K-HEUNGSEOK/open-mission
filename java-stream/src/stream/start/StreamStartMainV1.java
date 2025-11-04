package stream.start;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StreamStartMainV1 {
    public static void main(String[] args) {
        List<String> names = List.of("Apple", "Banana", "Berry", "Tomato");
        names.stream()
                .filter(n -> n.startsWith("B"))
                .map(String::toUpperCase)
                .collect(Collectors.toList())
                .forEach(System.out::println);


    }
}
