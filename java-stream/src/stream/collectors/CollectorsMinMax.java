package stream.collectors;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectorsMinMax {
    public static void main(String[] args) {
        System.out.println(Stream.of(1, 2, 3)
                .collect(Collectors.maxBy(Integer::compare))
                .orElse(-1));

        System.out.println(Stream.of(1, 2, 3)
                .max(Integer::compare).orElse(-1));

        System.out.println(IntStream.range(1, 4).max().getAsInt());
    }
}
