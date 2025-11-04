package lambda.lambda2;

public class Ex6 {
    public static void main(String[] args) {
       StringFunction hello = build("hello");
        System.out.println(hello.apply("java"));
    }
    static StringFunction build(String str){
        return name -> str + " , " + name;
    }
    interface StringFunction{
        String apply(String s);
    }
}
