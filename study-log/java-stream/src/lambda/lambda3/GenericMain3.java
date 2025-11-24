package lambda.lambda3;

public class GenericMain3 {
    public static void main(String[] args) {
        GenericFunction<String, String> func1 = s -> s.toUpperCase();
        GenericFunction<Integer, Integer> func2 = n -> n * n;
        System.out.println(func2.apply(5));
        System.out.println(func1.apply("hello"));

        GenericFunction<String,Integer> func3 = s -> Integer.parseInt(s,2);
        System.out.println(func3.apply("1111"));
    }
    @FunctionalInterface
    interface GenericFunction<T,R>{
        R apply(T s);
    }
}
