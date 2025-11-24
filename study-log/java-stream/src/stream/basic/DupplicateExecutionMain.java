package stream.basic;

import java.util.stream.Stream;

public class DupplicateExecutionMain {
    public static void main(String[] args) {
        Stream<Integer> integerStream = Stream.of(1, 2, 3);
        integerStream.forEach(System.out::println);


        integerStream.forEach(System.out::println);
    }
}
