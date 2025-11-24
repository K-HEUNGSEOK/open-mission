package lambda.lambda4;

import java.util.function.IntFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.ToIntFunction;

public class PrimitiveFunction {
    public static void main(String[] args) {
        IntFunction<String> function = s -> "value = " + s;
        System.out.println(function.apply(10));

        //기본형 반환
        ToIntFunction<String> intFunction = s -> s.length();
        System.out.println(intFunction.applyAsInt("qwer"));

        //기본형 입력, 기본형 반환
        IntToLongFunction function1 = x -> x * 100L;
        System.out.println(function1.applyAsLong(100));

        IntUnaryOperator unaryOperator = n -> n * n;
        System.out.println(unaryOperator.applyAsInt(10));

        //기타, IntConsumer, IntSupplier, IntPredicate
    }
}
