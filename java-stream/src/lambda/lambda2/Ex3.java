package lambda.lambda2;

import java.util.ArrayList;
import java.util.List;

public class Ex3 {
    public static void main(String[] args) {
        List<Integer> list = List.of(-3,-2,-1,1,2,3,5);
        List<Integer> filter = filter(list, value -> value < 0);
        List<Integer> filter2 = filter(list, value -> value % 2 == 0);
        System.out.println(filter);
        System.out.println(filter2);
    }

    static List<Integer> filter(List<Integer> list, MyPredict myPredict ){
        List<Integer> newList = new ArrayList<>();
        for (Integer num : list) {
            if (myPredict.test(num)){
                newList.add(num);
            }
        }
        return newList;
    }

    interface MyPredict{
        boolean test(int value);
    }
}
