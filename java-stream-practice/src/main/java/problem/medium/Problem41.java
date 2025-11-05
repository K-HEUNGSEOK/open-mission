package problem.medium;

import java.util.AbstractMap.SimpleEntry;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class Problem41 {

    /**
     * 주어진 문자열 리스트에서 'c'로 시작하는 문자열의 개수와 이들 문자열의 평균 길이를 계산합니다.
     * 만약 'c'로 시작하는 문자열이 없으면 개수는 0, 평균 길이는 0.0을 반환합니다.
     *
     * @param strings 문자열 리스트
     * @return 'c'로 시작하는 문자열의 개수와 평균 길이를 포함하는 SimpleEntry (개수, 평균 길이)
     */
    public static SimpleEntry<Long, Double> countAndAverageLengthOfStringsStartingWithC(List<String> strings) {
        IntSummaryStatistics collect = strings.stream().filter(n -> n.startsWith("c"))
                .collect(Collectors.summarizingInt(String::length));
        return new SimpleEntry<>(collect.getCount(), collect.getAverage());
    }
}
