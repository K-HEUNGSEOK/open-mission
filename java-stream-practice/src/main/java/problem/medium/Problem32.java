package problem.medium;

import java.util.List;

public class Problem32 {

    /**
     * 주어진 정수 리스트에서 10 이상 20 이하의 숫자만 필터링하고, 이를 제곱한 값으로 이루어진 리스트를 반환합니다.
     *
     * @param numbers 정수 리스트
     * @return 10 이상 20 이하의 숫자들의 제곱으로 이루어진 리스트
     */
    public static List<Integer> filterAndSquareNumbers(List<Integer> numbers) {
       return numbers.stream().filter(n -> n >= 10 && n <= 20).map(n -> n * n).toList();
    }
}
