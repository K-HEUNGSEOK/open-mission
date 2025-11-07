package problem.hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem64 {
    /**
     * 주어진 정수 리스트에서 피보나치 수열에 해당하는 수들의 합을 계산합니다.
     * 피보나치 수열은 0, 1, 1, 2, 3, 5, 8, 13, ... 과 같이 이전 두 수의 합으로 이루어진 수열입니다.
     *
     * @param numbers 정수 리스트
     * @return 피보나치 수열에 속하는 수들의 합
     */
    public static int sumOfFibonacciNumbers(List<Integer> numbers) {
        int maxInt = numbers.stream().mapToInt(Integer::intValue).max().getAsInt();
        int[] fibo = new int[maxInt+1];
        fibo[0] = 1;
        fibo[1] = 1;
        for(int i = 2; i < fibo.length; i ++){
            fibo[i] = fibo[i-1] + fibo[i-2];
        }
        Set<Integer> collect = Arrays.stream(fibo).boxed().collect(Collectors.toSet());

        return numbers.stream().filter(collect::contains)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int maxInt = numbers.stream().mapToInt(Integer::intValue).max().getAsInt();
        int[] fibo = new int[maxInt+1];
        fibo[0] = 1;
        for(int i = 2; i < fibo.length; i ++){
            fibo[i] = fibo[i-1] + fibo[i-2];
        }
        System.out.println(Arrays.toString(fibo));
    }
}
