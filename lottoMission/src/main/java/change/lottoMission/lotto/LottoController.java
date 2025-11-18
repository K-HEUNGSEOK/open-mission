package change.lottoMission.lotto;

import change.lottoMission.lotto.model.Lotto;
import change.lottoMission.lotto.model.LottoManager;
import change.lottoMission.lotto.model.LottoRank;
import change.lottoMission.lotto.util.CalculationUtils;
import change.lottoMission.lotto.util.LottoNumberGenerator;
import change.lottoMission.lotto.util.LottoValidator;
import change.lottoMission.lotto.view.InputView;
import change.lottoMission.lotto.view.OutView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class LottoController {
    private final InputView inputView;
    private final OutView outView;
    private final Scanner scanner;

    public LottoController(InputView inputView, OutView outView, Scanner scanner) {
        this.inputView = inputView;
        this.outView = outView;
        this.scanner = scanner;
    }

    public void execute() {
        int purchaseMoney = requestPurchaseAmount();
        int quantity = CalculationUtils.purchaseQuantityReturn(purchaseMoney);
        System.out.println(outView.formatPurchaseCount(quantity));

        List<Lotto> lottos = generateLottos(quantity);
        System.out.println(outView.formatPurchasedLottos(lottos));

        Lotto winningNumber = requestWinningNumbers();
        int bonusNumber = requestBonusNumbers(winningNumber);

        LottoManager lottoManager = new LottoManager(lottos, winningNumber, bonusNumber);
        Map<LottoRank, Integer> resultMap = lottoManager.calculateResults();

        printStatistics(resultMap, purchaseMoney);
    }

    private int requestPurchaseAmount() {
        while (true) {
            try {
                int purchaseMoney = LottoValidator.parseNumber(inputView.enterPurchaseAmount(scanner));
                LottoValidator.validateAmount(purchaseMoney);
                return purchaseMoney;
            } catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
            }
        }
    }

    private List<Lotto> generateLottos(int quantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottos.add(new Lotto(LottoNumberGenerator.lottoNumberReturn()));
        }
        return lottos;
    }

    private Lotto requestWinningNumbers() {
        while (true) {
            try {
                Lotto winningNumbers = new Lotto(LottoValidator.parseWinningNumbers(inputView.winningNumberInput(scanner)));
                LottoValidator.validateNumbers(winningNumbers.getNumbers());
                return winningNumbers;
            } catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
            }
        }
    }

    private int requestBonusNumbers(Lotto winningNumber) {
        while (true) {
            try {
                int bonusNumber = LottoValidator.parseNumber(inputView.bonusNumberInput(scanner));
                LottoValidator.validateBonusNumber(winningNumber.getNumbers(), bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
            }
        }
    }

    private void printStatistics(Map<LottoRank, Integer> resultMap, int purchaseMoney) {
        List<LottoRank> lottoRanks = getRanksForStatistics();

        long totalRewardMoney = 0;
        System.out.println(outView.formatWinningHeader());

        for (LottoRank lottoRank : lottoRanks) {
            int count = resultMap.get(lottoRank);
            if (count != 0) {
                totalRewardMoney += CalculationUtils.totalRewardMoney(lottoRank) * count;
            }
            System.out.println(outView.formatRankMessage(lottoRank, resultMap.get(lottoRank)));
        }
        System.out.println(
                outView.formatTotalProfitRate(CalculationUtils.calculateProfitRate(purchaseMoney, totalRewardMoney)));
    }

    private List<LottoRank> getRanksForStatistics() {
        List<LottoRank> ranks = new ArrayList<>(List.of(LottoRank.values()));
        ranks.remove(LottoRank.MISS);
        return ranks.reversed();
    }
}
