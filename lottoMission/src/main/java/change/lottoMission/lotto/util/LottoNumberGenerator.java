package change.lottoMission.lotto.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class LottoNumberGenerator {

    private LottoNumberGenerator() {
    }

    public static List<Integer> lottoNumberReturn() {
        Set<Integer> set = new HashSet<>();
        while (set.size() < 6) {
            set.add(new Random().nextInt(45) + 1);
        }
        List<Integer> lottos = new ArrayList<>(set);
        Collections.sort(lottos);
        return lottos;
    }
}
