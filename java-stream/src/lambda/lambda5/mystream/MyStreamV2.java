package lambda.lambda5.mystream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class MyStreamV2 {
    private List<Integer> integerList;

    private MyStreamV2(List<Integer> integerList) {
        this.integerList = integerList;
    }

    public MyStreamV2 filter(Predicate<Integer> predicate){
        List<Integer> filterd = new ArrayList<>();
        for (Integer num : integerList) {
            if (predicate.test(num)){
                filterd.add(num);
            }
        }
        return new MyStreamV2(filterd);
    }

    public static MyStreamV2 of(List<Integer> list){
        return new MyStreamV2(list);
    }


    public MyStreamV2 map(Function<Integer,Integer> function){
        List<Integer> list = new ArrayList<>();
        for (Integer num : integerList) {
            list.add(function.apply(num));
        }
        return new MyStreamV2(list);
    }
    public List<Integer> toList(){
        return integerList;
    }
}
