package stream.operation;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateOperationMain {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 9, 10);


        //1.filter
        System.out.println("짝수만 선택");
        numbers.stream().filter(n -> n % 2 == 0).forEach(n -> System.out.print(n + " "));
        System.out.println();

        //2. map
        System.out.println("각 숫자를 제곱");
        numbers.stream().map(n -> n * n ).forEach(n -> System.out.print(n + " "));
        System.out.println();


        //3.distinct
        System.out.println("중복을 제거");
        numbers.stream().distinct().forEach(n -> System.out.print(n + " "));
        System.out.println();

        //4.sorted (기본 정렬)
        System.out.println("기본 정렬");
        Stream.of(3,1,4,2,5).sorted().forEach(n -> System.out.print(n + " "));
        System.out.println();

        //5. 커스텀 정렬
        System.out.println("커스텀 정렬");
        Stream.of(3,1,4,2,5).sorted(Comparator.reverseOrder()).forEach(n -> System.out.print(n + " "));

        //6. peek
        System.out.println("peek 동작 확인용");
        numbers.stream().peek(n -> System.out.print("before : " + n + ", "))
                .map(n -> n * n)
                .peek(n -> System.out.print("after : " + n + ", "))
                .limit(5)
                .forEach(n -> System.out.println("최종값 : " + n));
        //7. limit
        System.out.println("limit 처음 5개 요소만");
        numbers.stream().limit(5).forEach(n -> System.out.print(n + " "));
        System.out.println();

        //8. skip
        System.out.println("처음 5개 요소를 건너뛰기");
        numbers.stream().skip(5).forEach(n -> System.out.print(n + " "));
        System.out.println();

        //9. takeWhile(java 9 이상부터) //조건을 만족할 때 만 출력하고 false가 나오는 순간 종료한다
        //정렬이 되어있을 때 사용해야 효과적
        List<Integer> numbers2 = List.of(1, 2, 3, 4, 5, 1, 2, 3);
        System.out.println("takeWhile - 5보다 작은 동안만 선택");
        numbers2.stream().takeWhile(n -> n < 5).forEach(n -> System.out.print(n + " "));
        System.out.println();

        //10. dropWhile(java 9 이상부터) //조건을 만족하기 전까진 건너뛰고 조건을 만족하면 그때부터 쭉 출력한다.
        System.out.println("5보다 작은동안 건너 뛴다");
        numbers2.stream().dropWhile(n -> n < 5).forEach(n -> System.out.print(n + " "));
        System.out.println();
    }
}
