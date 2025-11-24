package lambda.lambda4;

import java.util.function.Function;

public class FunctionMain {
    public static void main(String[] args) {
        Function<String,Integer> function = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };
        System.out.println("function.apply(\"hello\") = " + function.apply("hello"));

        Function<String,Integer> function1 = s -> s.length();
        System.out.println("function1.apply(\"hello\") = " + function1.apply("hello"));
    }
}
