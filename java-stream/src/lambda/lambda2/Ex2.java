package lambda.lambda2;

import lambda.lambda1.MyFunction;

public class Ex2 {
    public static void main(String[] args) {
        System.out.println(getOperator("add").apply(1, 2));
        System.out.println(getOperator("sub").apply(1, 2));
        System.out.println(getOperator("ewq").apply(1, 2));
    }
    static MyFunction getOperator(String str){
        switch (str){
            case "add":
                return (a,b) -> a+b;
            case "sub":
                return (a,b) -> a-b;
            default:
                return (a,b) -> 0;
        }
    }
}
