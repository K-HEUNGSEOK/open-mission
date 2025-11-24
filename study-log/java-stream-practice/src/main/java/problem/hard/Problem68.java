package problem.hard;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem68 {

    /**
     * 주어진 정수 리스트에서 각 숫자의 빈도와 전체 숫자의 평균을 계산합니다.
     * 결과는 각 숫자와 그 빈도, 전체 평균을 포함하는 Map으로 반환합니다.
     *
     * @param numbers 정수 리스트
     * @return 각 숫자의 빈도와 전체 평균을 포함하는 Map
     */
    public static Map<Integer, String> calculateFrequencyAndAverage(List<Integer> numbers) {
        // 여기에 코드 작성
        double average = numbers.stream()
                .mapToInt(Integer::intValue)
                .average().orElse(0.0);

        Map<Integer, Long> temp = numbers.stream()
                .collect(Collectors.groupingBy(
                        key -> key,
                        Collectors.counting()
                ));
       return temp.entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> String.format("Freq: %d, Avg: %.2f", entry.getValue(), average)
                ));
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1,1,2,2,3,3);
        Map<Integer, Long> temp = numbers.stream()
                .collect(Collectors.groupingBy(
                        key -> key,
                        Collectors.counting()
                ));
        System.out.println(temp);
    }
}
