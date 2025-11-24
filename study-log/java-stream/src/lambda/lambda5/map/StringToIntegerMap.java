package lambda.lambda5.map;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class StringToIntegerMap {
    private StringToIntegerMap() {
    }

    public static List<Integer> mapper(List<String> list, Function<String,Integer> function){
        List<Integer> newList = new ArrayList<>();
        for (String s : list) {
            newList.add(function.apply(s));
        }
        return newList;
    }
}
