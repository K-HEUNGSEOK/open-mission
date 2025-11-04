package lambda.lambda5.filter;

import java.util.List;

public class FilterMainV3 {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3,4,5,6,7,8,9,10);
        List<Integer> evenList = GenericFilter.filter(list, n -> n % 2 == 0);
        System.out.println("짝수만 = " + evenList);

        List<String> stringList = List.of("A", "BB" , "CCC");
        List<String> lengthList = GenericFilter.filter(stringList, s -> s.length() > 1);
        System.out.println("lengthList = " + lengthList);

    }
}
