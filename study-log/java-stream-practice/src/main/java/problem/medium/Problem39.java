package problem.medium;

import java.util.List;

public class Problem39 {

    /**
     * 주어진 정수 리스트에서 5보다 큰 숫자들의 제곱합을 계산하여 반환합니다.
     *
     * @param numbers 정수 리스트
     * @return 5보다 큰 숫자들의 제곱합
     */
    public static int sumOfSquaresOfNumbersGreaterThanFive(List<Integer> numbers) {
        return numbers.stream().filter(n -> n > 5)
                .mapToInt(n -> n * n)
                .sum();

    }
}
