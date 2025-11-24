package lambda.lambda5.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class GenericFilter {
    private GenericFilter() {
    }

    public static <T>List<T> filter(List<T> list , Predicate<T> predicate){
        List<T> newList = new ArrayList<>();
        for (T i : list) {
            if (predicate.test(i)){
                newList.add(i);
            }
        }
        return newList;
    }
}
