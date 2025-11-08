package problem.hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Problem70 {

    /**
     * 주어진 정수 리스트에서 각 숫자의 소수 여부를 판별하고, 리스트 내 최대 소수를 찾습니다. 결과는 각 숫자의 소수 여부와 리스트 내 최대 소수를 포함하는 Map으로 반환합니다.
     *
     * @param numbers 정수 리스트
     * @return 각 숫자의 소수 여부와 최대 소수를 포함하는 Map
     */
    public static Map<Object, Object> identifyPrimesAndFindMax(List<Integer> numbers) {
        //1. 소수 구하기
        int maxNum = numbers.stream().mapToInt(Integer::intValue).max().getAsInt();
        boolean[] prime = new boolean[maxNum + 1];
        prime[0] = true;
        prime[1] = true;
        for (int i = 2; i <= maxNum; i++) {
            for (int j = i * i; j <= maxNum; j += i) {
                if (!prime[j]) {
                    prime[j] = true;
                }
            }
        }

        //2. 소수 판단 로직 prime true 면 Not Prime, false 면 Prime 으로 해야함
        Map<Integer, String> temp = numbers.stream()
                .collect(Collectors.toMap(
                        key -> key,
                        value -> prime[value] ? "Not Prime" : "Prime",
                        (oldVal, newVal) -> oldVal
                ));

        Optional<Integer> max = numbers.stream().filter(n -> !prime[n])
                .max(Comparator.comparing(Integer::intValue));

        Map<Object, Object> resultMap = new HashMap<>(temp);
        max.ifPresent(n -> resultMap.put("Max Prime",max.get()));
        return resultMap;
    }

}
