package problem.medium;

import java.util.List;

public class Problem42 {

    /**
     * 주어진 정수 리스트에서 3의 배수와 5의 배수를 찾아,
     * 이들 중 3의 배수는 그대로 두고, 5의 배수는 2배한 후 합산합니다.
     *
     * @param numbers 정수 리스트
     * @return 조건을 만족하는 숫자들의 합
     */
    public static int sumSpecialMultiples(List<Integer> numbers) {
       return numbers.stream().filter(n -> n % 3 == 0 || n % 5 == 0)
                .mapToInt(
                        n -> {
                            if (n % 5 == 0){
                                return n * 2;
                            }else{
                                return n;
                            }
                        })
                .sum();

    }
}
