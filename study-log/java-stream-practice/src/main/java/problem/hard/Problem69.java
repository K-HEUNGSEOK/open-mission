package problem.hard;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem69 {
    static char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    /**
     * 주어진 문자열 리스트에서 각 문자열에 대해 알파벳 순서 대칭 점수를 계산합니다.
     * 알파벳 순서 대칭 점수는 문자열 내 각 문자의 알파벳 순서를 기준으로 대칭 위치에 있는 문자의 순서와의 차이의 합입니다.
     * 예를 들어, "abc"의 점수는 |1-3| + |2-2| = 2입니다. ('a'(1)와 'c'(3)의 차이)
     *
     * @param strings 문자열 리스트
     * @return 각 문자열의 알파벳 순서 대칭 점수를 포함하는 Map
     */
    public static Map<String, Integer> calculateAlphabeticalSymmetryScore(List<String> strings) {
        return strings.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toMap(
                        key -> key,
                        value -> {
                            int lengthValue = value.length();

                           return IntStream.range(0, lengthValue/2)
                                    .map(i -> {
                                        int leftVal = value.charAt(i) -'a' + 1;
                                        int rightValue = value.charAt(lengthValue - 1 - i) - 'a' + 1;
                                        return Math.abs(leftVal - rightValue);
                                    }).sum();
                        }
                ));
    }
}
