package lambda.lambda4;

import java.util.function.Function;
import java.util.function.Predicate;

public class PredicateMain {
    public static void main(String[] args) {
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer % 2 ==0;
            }
        };
        System.out.println(predicate.test(2));
        System.out.println(predicate.test(3));

        Predicate<Integer> predicate1 = n -> n % 2 == 0;
        System.out.println(predicate1.test(2));
        System.out.println(predicate1.test(3));

        Function<Integer,Boolean> function = n -> n % 2 == 0;
        System.out.println(function.apply(200));
    }
}
