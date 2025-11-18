package change.lottoMission.lotto.view;

import change.lottoMission.lotto.model.Lotto;
import change.lottoMission.lotto.model.LottoRank;
import java.util.List;


public class OutView {
    private final String ANNOUNCE_PURCHASE_COUNT = "%d개를 구매했습니다.";
    private final String HEADER_WINNING = "당첨 통계";
    private final String DELIMITER = "---";
    private final String RESULT_FORMAT_NORMAL = "%d개 일치 (%s원) - %d개";
    private final String RESULT_FORMAT_SECOND = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private final String RESULT_PROFIT_RATE = "총 수익률은 %.1f%%입니다.";

    public String formatPurchaseCount(int count) {
        return String.format(ANNOUNCE_PURCHASE_COUNT, count);
    }

    public String formatPurchasedLottos(List<Lotto> lottos) {
        StringBuilder sb = new StringBuilder();

        for (Lotto lotto : lottos) {
            sb.append(lotto.getNumbers()).append("\n");
        }
        return sb.toString();
    }

    public String formatWinningHeader() {
        return HEADER_WINNING + "\n" + DELIMITER;
    }

    public String formatRankMessage(LottoRank lottoRank, int count) {
        if (lottoRank == LottoRank.SECOND) {
            return String.format(RESULT_FORMAT_SECOND, lottoRank.getMatchCount(), lottoRank.getRewardMoney(), count);
        }
        return String.format(RESULT_FORMAT_NORMAL, lottoRank.getMatchCount(), lottoRank.getRewardMoney(), count);
    }

    public String formatTotalProfitRate(double profitRate) {
        return String.format(RESULT_PROFIT_RATE, profitRate);
    }


}
