package lambda.lambda3;

import java.util.function.Function;

public class TargetType2 {
    public static void main(String[] args) {
        Function<String,Integer> uppercase = s -> Integer.parseInt(s,2);
        System.out.println(uppercase.apply("1101"));

        Function<String,Integer> test = s -> s.length();
        uppercase = test;
        System.out.println(uppercase.apply("Ewqrqwe"));
    }
}
