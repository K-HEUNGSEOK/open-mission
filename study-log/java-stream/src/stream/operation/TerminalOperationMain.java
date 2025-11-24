package stream.operation;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TerminalOperationMain {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 9, 10);

        System.out.println("1. collect - List 수집");
        //기본 toList( ) 는 자바 16에 도입됨
        List<Integer> evenList = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        System.out.println("짝수 리스트 : " + evenList);

        System.out.println("2. toArry() - 배열로 변환");
        Integer[] array = numbers.stream().filter(n -> n % 2 == 0).toArray(Integer[]::new);
        System.out.println("짝수 배열 : " + Arrays.toString(array));

        System.out.println("3. count - 요소 개수");
        long count = numbers.stream().filter(n -> n > 5).count();
        System.out.println("count = " + count);

        System.out.println("4. reduce - 요소들의 합");
        System.out.println("초기값이 없는 reduce");
        Optional<Integer> reduce = numbers.stream().reduce((a, b) -> a + b);
        System.out.println("합계(초기값 없음) : " + reduce.get());

        System.out.println("초기값이 있는 reduce");
        int reduce2 = numbers.stream().reduce(100,(a, b) -> a + b);
        System.out.println("합계(초기값 : 100) : " + reduce2);

        System.out.println("5. min 최소값");
        System.out.println(numbers.stream().min(Integer::compareTo).orElse(null));

        System.out.println("6. max 최대값");
        System.out.println(numbers.stream().max(Integer::compareTo).orElse(null));

        System.out.println("7. findFirst");
        System.out.println(numbers.stream().filter(n -> n > 5).findFirst().orElseThrow());

        System.out.println("8. findAny 아무 요소나 하나 찾기"); //멀티 스레드에서 차이가 있지만 평소엔 findFirst와 같음
        System.out.println(numbers.stream().filter(n -> n > 5).findAny().orElseThrow());

        System.out.println("9. anyMatch 조건을 만족하는 요소 존재 여부");
        System.out.println(numbers.stream().anyMatch(n -> n % 2 == 0));

        System.out.println("10. allMatch 모든 요소가 조건을 만족하냐");
        System.out.println(numbers.stream().allMatch(n -> n % 2 == 0));

        System.out.println("11. noneMatch 조건을 만족하는 요소가 없는지");
        System.out.println(numbers.stream().noneMatch(n -> n < 0));
    }
}
