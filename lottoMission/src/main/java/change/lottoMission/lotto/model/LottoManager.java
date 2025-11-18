package change.lottoMission.lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoManager {
    private final List<Lotto> purchasedLottos;
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public LottoManager(List<Lotto> purchasedLottos, Lotto winningNumbers, int bonusNumber) {
        this.purchasedLottos = purchasedLottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Map<LottoRank, Integer> calculateResults() {
        Map<LottoRank, Integer> resultMap = new HashMap<>();

        for (LottoRank value : LottoRank.values()) {
            resultMap.put(value, 0);
        }

        for (Lotto purchasedLotto : purchasedLottos) {
            int matchCount = calculateMatchCount(purchasedLotto);
            boolean bonusMatch = purchasedLotto.containsNumber(bonusNumber);
            LottoRank lottoRank = LottoRank.findRank(matchCount, bonusMatch);

            resultMap.put(lottoRank, resultMap.get(lottoRank) + 1);
        }
        return resultMap;
    }


    int calculateMatchCount(Lotto purchasedLotto) {
        List<Integer> winningNums = winningNumbers.getNumbers();
        int matchCount = 0;
        for (Integer winningNum : winningNums) {
            if (purchasedLotto.containsNumber(winningNum)) {
                matchCount++;
            }
        }
        return matchCount;
    }


}
