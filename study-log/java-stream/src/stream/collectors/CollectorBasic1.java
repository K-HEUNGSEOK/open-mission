package stream.collectors;

import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorBasic1 {
    public static void main(String[] args) {
        //수정 가능한 list 반환
        List<String> list = Stream.of("Java", "Spring", "JPA")
                .collect(Collectors.toList());
        System.out.println("list = " + list);
        //수정 불가능 한 list
        List<Integer> unmodifiableList = Stream.of(1, 2, 3).collect(Collectors.toUnmodifiableList());

        Stream.of(1,2,2,2,3,3,3).collect(Collectors.toSet()).forEach(n -> System.out.print(n + " "));
        System.out.println();

        //타입 지정
        TreeSet<Integer> treeSet = Stream.of(3, 4, 5, 2, 1).collect(Collectors.toCollection(TreeSet::new));
        System.out.println("treeSet = " + treeSet);
    }
}
