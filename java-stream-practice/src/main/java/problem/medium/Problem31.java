package problem.medium;

import java.util.Comparator;
import java.util.List;

public class Problem31 {

    /**
     * 주어진 문자열 리스트에서 길이가 3 이상 7 이하인 문자열 중에서 'e'를 포함하고 있는 문자열들만을
     * 대문자로 변환한 뒤 이를 알파벳 순으로 정렬하여 반환합니다.
     *
     * @param strings 원본 문자열 리스트
     * @return 조건을 만족하는 대문자로 변환된, 정렬된 문자열 리스트
     */
    public static List<String> transformAndSortStrings(List<String> strings) {
       return strings.stream().filter(n -> n.length() >= 3 && n.length() <= 7 && n.contains("e"))
                .map(String::toUpperCase).sorted().toList();
    }
}
