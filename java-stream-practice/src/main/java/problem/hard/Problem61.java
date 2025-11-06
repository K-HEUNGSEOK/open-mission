package problem.hard;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem61 {

    /**
     * 주어진 문자열 리스트에서, 'key=value' 형태의 패턴을 가진 문자열을 찾아,
     * 이를 Map으로 변환합니다. 여기서 key는 Map의 키로, value는 정수 값으로 변환되어 Map의 값이 됩니다.
     * 문자열이 올바른 'key=value' 형태가 아니거나, value가 정수로 변환될 수 없는 경우 해당 문자열은 무시합니다.
     *
     * @param strings 문자열 리스트
     * @return 'key=value' 패턴의 문자열을 key와 정수 value로 변환한 Map
     */
    //1. 문자열에서 = 를 찾는다
    //2. 그걸 기준으로 spllit 으로 짜른다
    //3. value가 숫자인지 확인하고 filter 한다.
    public static Map<String, Integer> extractKeyValuePairs(List<String> strings) {
        return strings.stream()
                .filter(s -> s.contains("="))
                .map(s -> s.split("="))
                .filter(i -> Character.isDigit(i[1].charAt(0)))
                .collect(Collectors.toMap(
                        key -> key[0],
                        value -> Integer.parseInt(value[1])
                ));

    }
}
