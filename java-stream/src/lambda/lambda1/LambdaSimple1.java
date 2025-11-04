package lambda.lambda1;

public class LambdaSimple1 {
    public static void main(String[] args) {
        //기본 코드
        MyFunction myFunction1 = (a, b ) -> {
            return a + b;
        };
        System.out.println("myFunction1.apply(1,2) = " + myFunction1.apply(1,2));


    }
}
