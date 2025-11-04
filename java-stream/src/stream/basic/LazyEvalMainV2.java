package stream.basic;

import java.util.Arrays;
import java.util.List;
import lambda.lambda5.mystream.MyStreamV3;

public class LazyEvalMainV2 {
    static int[] money = {50000, 10000, 5000, 1000, 500, 100, 500, 10};
    static int[] arr;
    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3,4,5,6);
        System.out.println(list.stream().filter(n -> n % 2 == 0).
                map(n -> n * 10)
                .findFirst()
                .get());

        System.out.println(MyStreamV3.of(list)
                .filter(n -> n % 2 == 0)
                .map(n -> n * 10)
                .getFirst());

        arr = new int[8];
        Arrays.stream(arr).forEach(n -> System.out.println(n));
    }
}
