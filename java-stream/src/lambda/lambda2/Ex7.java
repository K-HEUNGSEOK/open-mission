package lambda.lambda2;

public class Ex7 {
    public static void main(String[] args) {
        String str = "hello";
       MyTransformer z = compose(s -> s.toUpperCase(), s -> "***" + s + "***");
        System.out.println(z.transform(str));
    }
    static MyTransformer compose(MyTransformer f1, MyTransformer f2){
        return s -> {
            String str = f1.transform(s);
            return f2.transform(str);
        };
    }
    public interface MyTransformer {
        String transform(String s);
    }
}
