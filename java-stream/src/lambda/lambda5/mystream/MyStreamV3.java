package lambda.lambda5.mystream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class MyStreamV3<T> {
    private List<T> integerList;

    private MyStreamV3(List<T> integerList) {
        this.integerList = integerList;
    }

    public MyStreamV3<T> filter(Predicate<T> predicate){
        List<T> filterd = new ArrayList<>();
        for (T num : integerList) {
            if (predicate.test(num)){
                filterd.add(num);
            }
        }
        return MyStreamV3.of(filterd);
    }

    public static <T>MyStreamV3<T> of(List<T> list){
        return new MyStreamV3<>(list);
    }


    public <R> MyStreamV3<R> map(Function<T,R> function){
        List<R> list = new ArrayList<>();
        for (T num : integerList) {
            list.add(function.apply(num));
        }
        return MyStreamV3.of(list);
    }
    public List<T> toList(){
        return integerList;
    }

    public void forEach(Consumer<T> consumer){
        for (T t : integerList) {
            consumer.accept(t);
        }
    }
    public T getFirst(){
        return integerList.getFirst();
    }
}
