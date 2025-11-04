package stream.collectors;

import java.util.List;
import java.util.stream.Collectors;

public class CollectorsReducing {
    public static void main(String[] args) {
        List<String> names = List.of("a", "b", "c", "d", "e");

        System.out.println(names.stream()
                .collect(Collectors.reducing((s1, s2) -> s1 + s2))
                .get());

        System.out.println(names.stream().reduce((s1, s2) -> s1 + "," + s2).get());
        System.out.println(names);
        String collect = names.stream().collect(Collectors.joining(","));
        System.out.println(collect);

        System.out.println(String.join(",", names));
    }
}
