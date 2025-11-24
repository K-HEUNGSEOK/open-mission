package lambda.lambda5.mystream;

import com.sun.source.tree.NewArrayTree;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class MyStreamV1 {
    private List<Integer> integerList;

    public MyStreamV1(List<Integer> integerList) {
        this.integerList = integerList;
    }

    public MyStreamV1 filter(Predicate<Integer> predicate){
        List<Integer> filterd = new ArrayList<>();
        for (Integer num : integerList) {
            if (predicate.test(num)){
                filterd.add(num);
            }
        }
        return new MyStreamV1(filterd);
    }
    public MyStreamV1 map(Function<Integer,Integer> function){
        List<Integer> list = new ArrayList<>();
        for (Integer num : integerList) {
            list.add(function.apply(num));
        }
        return new MyStreamV1(list);
    }
    public List<Integer> toList(){
        return integerList;
    }
}
