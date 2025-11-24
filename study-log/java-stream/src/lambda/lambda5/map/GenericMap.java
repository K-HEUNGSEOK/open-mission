package lambda.lambda5.map;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class GenericMap {
    private GenericMap() {
    }
    //입력이 String T, 반환이 Integer R
    public static <T,R>List<R> mapper(List<T> list, Function<T,R> function){
        List<R> newList = new ArrayList<>();
        for (T s : list) {
            newList.add(function.apply(s));
        }
        return newList;
    }
}
