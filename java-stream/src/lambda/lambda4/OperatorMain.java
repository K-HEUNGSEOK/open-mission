package lambda.lambda4;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class OperatorMain {
    public static void main(String[] args) {

        UnaryOperator<Integer> unaryOperator = n -> n * n;
        System.out.println(unaryOperator.apply(2));
        UnaryOperator<String> unaryOperator1 = n -> n.toUpperCase();
        System.out.println(unaryOperator1.apply("re"));

        Function<Integer,Integer> function = n -> n * n;
        System.out.println(function.apply(10));

        BiFunction<Integer,Integer,Integer> biFunction = (a, b) -> a + b;
        System.out.println(biFunction.apply(1, 2));

        BinaryOperator<Integer> binaryOperator = (a,b) -> a + b;
        System.out.println(binaryOperator.apply(2, 3));
    }

}
