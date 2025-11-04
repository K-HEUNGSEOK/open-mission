package lambda.lambda3;

public class GenericMain4 {
    public static void main(String[] args) {
        GenericFunction<String, String> f1 = s -> s.toUpperCase();
        GenericFunction<String,Integer> f2 = s -> s.length();
        GenericFunction<Integer,Integer> f3 = x -> x * x;
        GenericFunction<Integer,Boolean> f4 = n -> n % 2 == 0;
        System.out.println(f4.apply(2));
        System.out.println(f4.apply(3));
    }
    @FunctionalInterface
    interface GenericFunction<T,R>{
        R apply(T s);
    }
}
