package lambda.lambda3;

public class TargetType1 {
    public static void main(String[] args) {
        FunctionA functionA = n -> "value = " + n;
        FunctionB functionB = n -> "value = " + n;


    }
    @FunctionalInterface
    interface FunctionA{
        String apply (Integer i);
    }
    @FunctionalInterface
    interface FunctionB{
        String apply (Integer i);
    }
}
