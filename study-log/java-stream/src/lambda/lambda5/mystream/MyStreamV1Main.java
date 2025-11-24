package lambda.lambda5.mystream;

import java.util.List;

public class MyStreamV1Main {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3,4,5,6,7,8,9,10);
        MyStreamV1 myStreamV1 = new MyStreamV1(list);
        List<Integer> list1 = myStreamV1.filter(n -> n % 2 == 0).map(n -> n * 2).toList();
        System.out.println("list1 = " + list1);
    }
}
