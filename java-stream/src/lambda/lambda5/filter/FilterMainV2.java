package lambda.lambda5.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FilterMainV2 {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3,4,5,6,7,8,9,10);
        List<Integer> evenList = IntegerFilter.filter(list, n -> n % 2 == 0);
        List<Integer> oddList = IntegerFilter.filter(list, n -> n % 2 != 0);

        System.out.println("짝수만 = " + evenList);
        System.out.println("홀수만 = " + oddList);
    }
}
