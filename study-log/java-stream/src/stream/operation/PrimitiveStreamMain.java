package stream.operation;

import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class PrimitiveStreamMain {
    public static void main(String[] args) {
        //기본형 특화 스트림 생성
        IntStream intStream = IntStream.of(1, 2, 3, 4, 5);
        intStream.forEach(i -> System.out.print(i + " "));
        System.out.println();

        IntStream.range(1,6).forEach(n -> System.out.print(n + " "));
        System.out.println();
        IntStream.rangeClosed(1,6).forEach(n -> System.out.print(n + " "));
        System.out.println();
        //통계관련 메서드
        System.out.println(IntStream.range(1, 6).sum());
        double asDouble = IntStream.range(1, 5).average().getAsDouble();
        System.out.println("asDouble = " + asDouble);

        IntSummaryStatistics intSummaryStatistics = IntStream.range(1, 6).summaryStatistics();
        System.out.println(intSummaryStatistics.getSum());
        System.out.println(intSummaryStatistics.getAverage());
        System.out.println(intSummaryStatistics.getMax());
        System.out.println(intSummaryStatistics.getMin());

        //타입변환 메서드
        LongStream longStream = IntStream.range(1, 5).asLongStream();
        Stream<Integer> boxed = IntStream.range(1, 5).boxed(); //참조형으로 변환

        //기본형 특화 매핑
        LongStream longStream1 = IntStream.range(1, 5).mapToLong(i -> i * 10L);
        DoubleStream doubleStream = IntStream.range(1, 5).mapToDouble(i -> i * 5.0);

        //기본형 -> 객체
        Stream<String> stringStream = IntStream.range(1, 5).mapToObj(n -> "number " + n);
        //객체 -> 기본형
        Stream.of(1,2,3,4,5).mapToInt(i -> i).sum();
        Stream.of(1, 2, 3, 4, 5).mapToInt(Integer::intValue).sum();
    }
}
