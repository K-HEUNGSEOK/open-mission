package change.lottoMission.lotto.model;

import change.lottoMission.lotto.util.CalculationUtils;
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
            int matchCount = purchasedLotto.countMatch(winningNumbers);
            boolean bonusMatch = purchasedLotto.containsNumber(bonusNumber);

            LottoRank lottoRank = LottoRank.findRank(matchCount, bonusMatch);
            resultMap.put(lottoRank, resultMap.get(lottoRank) + 1);
        }
        return resultMap;
    }

    public long calculateTotalPrize(Map<LottoRank, Integer> resultMap) {
        long totalPrize = 0;
        for (LottoRank lottoRank : resultMap.keySet()) {
            int count = resultMap.get(lottoRank);
            if (count > 0) {
                totalPrize += (long) lottoRank.getRewardMoney() * count;
            }
        }
        return totalPrize;
    }


}
