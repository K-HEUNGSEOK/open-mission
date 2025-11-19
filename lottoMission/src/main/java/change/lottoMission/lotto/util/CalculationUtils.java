package change.lottoMission.lotto.util;


import change.lottoMission.lotto.model.LottoRank;
import change.lottoMission.lotto.model.dto.PurchaseMoney;

public class CalculationUtils {

    private CalculationUtils() {
    }

    public static int purchaseQuantityReturn(PurchaseMoney purchaseMoney) {
        return purchaseMoney.getMoney() / 1000;
    }

    public static double calculateProfitRate(int purchaseAmount, long winningAmount) {
        return ((double) winningAmount / purchaseAmount) * 100;
    }

    public static long totalRewardMoney(LottoRank lottoRank) {
        return Integer.parseInt(lottoRank.getRewardMoney().replace(",", ""));
    }

}
