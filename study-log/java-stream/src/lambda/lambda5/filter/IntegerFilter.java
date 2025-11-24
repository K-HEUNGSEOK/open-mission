package lambda.lambda5.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class IntegerFilter {
    private IntegerFilter() {
    }

    public static List<Integer> filter(List<Integer> list , Predicate<Integer> predicate){
        List<Integer> newList = new ArrayList<>();
        for (Integer i : list) {
            if (predicate.test(i)){
                newList.add(i);
            }
        }
        return newList;
    }
}
