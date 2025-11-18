package change.lottoMission.lotto.util;


import change.lottoMission.lotto.model.LottoRank;

public class CalculationUtils {

    private CalculationUtils() {
    }

    public static int purchaseQuantityReturn(int purchaseAmount) {
        return purchaseAmount / 1000;
    }

    public static double calculateProfitRate(int purchaseAmount, long winningAmount) {
        return ((double) winningAmount / purchaseAmount) * 100;
    }

    public static long totalRewardMoney(LottoRank lottoRank) {
        return Integer.parseInt(lottoRank.getRewardMoney().replace(",", ""));
    }

}
