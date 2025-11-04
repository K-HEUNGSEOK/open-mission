package lambda.lambda4;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class BiMain {
    public static void main(String[] args) {
        BiFunction<Integer,Integer,Integer> biFunction = (a,b) -> a + b;

        BiConsumer<String,Integer> consumer = (c,n) -> {
            for(int i = 0 ; i < n; i ++){
                System.out.print(c);
            }
            System.out.println();
        };
        consumer.accept("*",5);

        BiPredicate<Integer,Integer> biPredicate = (a,b) -> a > b;
        System.out.println(biPredicate.test(10, 5));
        System.out.println(biPredicate.test(5, 10));
    }
}
