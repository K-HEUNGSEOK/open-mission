package stream.operation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MapFlatMapMain {
    public static void main(String[] args) {
        List<List<Integer>> outerList = List.of(
                List.of(1, 2),
                List.of(3, 4),
                List.of(5, 6)
        );
        //1. for문으로 합치기
        List<Integer> forResult = new ArrayList<>();
        for (List<Integer> integerList : outerList) {
            for (Integer i : integerList) {
                forResult.add(i);
            }
        }
        System.out.println(forResult);

        //2.map
        List<Stream<Integer>> mapResult = outerList.stream().map(list -> list.stream()).toList();
        System.out.println("mapResult = " + mapResult);

        //3.faltMap
        List<Integer> flatMapResult = outerList.stream().flatMap(list -> list.stream()).toList();
        System.out.println("flatMapResult = " + flatMapResult);
    }
}
