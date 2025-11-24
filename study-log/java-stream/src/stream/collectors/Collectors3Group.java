package stream.collectors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Collectors3Group {
    public static void main(String[] args) {
        //첫 글자 알파벳을 기준으로 그룹화
        List<String> names = List.of("Apple", "Avocado", "Banana", "Blueberry", "Cherry");
        Map<String, List<String>> grouped = names.stream()
                .collect(Collectors.groupingBy(n -> n.substring(0, 1)));
        System.out.println("grouped = " + grouped);

        //이건 true / false 두 그룹으로 나뉘는 것
        List<Integer> numbers = List.of(1,2,3,4,5,6);
        Map<Boolean, List<Integer>> grouped2 = numbers.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("grouped2 = " + grouped2);
    }
}
