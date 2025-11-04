package stream.basic;

import java.util.List;
import java.util.stream.Stream;
import lambda.lambda5.mystream.MyStreamV3;

public class LazyEvalMainV1 {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3,4,5,6);
        ex1(list);
        ex2(list);
    }
    static void ex1(List<Integer> list){
        System.out.println("MyStreamV3 시작");
        MyStreamV3.of(list)
                .filter(n -> n % 2 == 0)
                .map(n -> n * 10)
                .forEach(System.out::println);
    }
    static void ex2(List<Integer> list){
        System.out.println("자바의 Stream 시작");
        list.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * 10)
                .forEach(System.out::println);
    }
}
