package problem.easy;

import java.util.List;

public class Problem9 {

    /**
     * 주어진 문자열 리스트의 각 문자열에 대해 길이가 3이상이면 대문자로 변환하고, 그렇지 않으면 그대로 두는 새로운 리스트를 반환합니다.
     *
     * @param strings 원본 문자열 리스트
     * @return 변환된 문자열 리스트
     */
    public static List<String> transformStrings(List<String> strings) {
        // 처음엔 filter를 사용했어서 안됐었다. filter는 거름망 역할을 하기 때문에 이런 조건은 map 으로 실시한다.
        return strings.stream().map(s -> (s.length() >= 3) ? s.toUpperCase() : s).toList();
    }
}