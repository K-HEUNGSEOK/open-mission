package lambda.lambda2;
import java.util.*;
public class Ex4 {

    public static void main(String[] args) {
        List<String> list = List.of("hello", "java", "lambda");
        List<String> map = map(list, s -> s.toUpperCase());
        System.out.println(map);
        List<String> map2 = map(list, s -> "***" + s + "***");
        System.out.println(map2);
    }

    static List<String> map(List<String> list , StringFunction stringFunction){
        List<String> newList = new ArrayList<>();
        for (String s : list) {
            newList.add(stringFunction.apply(s));
        }
        return newList;
    }


    interface StringFunction{
        String apply(String s);
    }
}
