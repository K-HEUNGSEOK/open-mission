package change.lottoMission.lotto.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoNumberGeneratorTest {

    @Test
    void test(){
        Set<Integer> set = new HashSet<>();
        while (set.size() < 6){
            set.add(new Random().nextInt(45)+1);
        }
        List<Integer> lottos = new ArrayList<>(set);
        Assertions.assertThat(lottos.size()).isEqualTo(6);
    }
}