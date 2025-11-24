package lambda.lambda1;

public class LambdaSimple2 {
    public static void main(String[] args) {
        Produce produce = () -> System.out.println("hello lambda");
        produce.run();
        MyCall myCall = a -> a * 2;
        System.out.println(myCall.call(2));
    }

    interface MyCall{
        int call(int value);
    }
}
