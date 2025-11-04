package problem.medium;

import java.util.List;

public class Problem37 {

    /**
     * 주어진 문자열 리스트에서 'a'를 포함하는 단어의 개수를 세어 반환합니다.
     *
     * @param words 문자열 리스트
     * @return 'a'를 포함하는 단어의 개수
     */
    public static long countWordsContainingA(List<String> words) {
        return words.stream().filter(n -> n.contains("a")).count();
    }
}
