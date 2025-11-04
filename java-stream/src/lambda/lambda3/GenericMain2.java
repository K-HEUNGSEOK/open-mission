package lambda.lambda3;

public class GenericMain2 {
    public static void main(String[] args) {
        StringFunction<String> str = s -> s.toUpperCase();
        System.out.println(str.apply("hello"));

        StringFunction<Integer> num = n -> n * n;
        System.out.println(num.apply(3));
    }
    @FunctionalInterface
    interface StringFunction<T>{
        T apply(T s);
    }
    @FunctionalInterface
    interface NumberFunction{
        Integer apply(Integer s);
    }
}
