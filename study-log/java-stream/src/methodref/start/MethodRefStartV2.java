package methodref.start;

import java.util.function.BinaryOperator;

public class MethodRefStartV2 {
    public static void main(String[] args) {
        BinaryOperator<Integer> add1 = (x,y) -> add(x,y);
        Integer result1 = add1.apply(1, 2);
        Integer result2 = add1.apply(1, 2);
    }
    static int add (int x , int y){
        return x + y;
    }
}
