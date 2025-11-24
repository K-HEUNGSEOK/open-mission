package stream.collectors;

import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Collectors4Summing {
    public static void main(String[] args) {
        System.out.println(Stream.of(1, 2, 3)
                .collect(Collectors.counting()));
        System.out.println(IntStream.range(1, 4).count());

        System.out.println(Stream.of(1, 2, 3).mapToInt(Integer::intValue)
                .average()
                .getAsDouble());

        System.out.println(IntStream.of(1, 2, 3).average().getAsDouble());

        IntSummaryStatistics collect = Stream.of("Apple", "Banana", "Tomato")
                .collect(Collectors.summarizingInt(String::length));
        System.out.println(collect.getSum());

    }
}
