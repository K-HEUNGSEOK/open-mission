package change.lottoMission.lotto;

import change.lottoMission.lotto.model.Lotto;
import change.lottoMission.lotto.model.LottoManager;
import change.lottoMission.lotto.model.LottoRank;
import change.lottoMission.lotto.model.dto.PurchaseMoney;
import change.lottoMission.lotto.model.dto.WinningForm;
import change.lottoMission.lotto.util.CalculationUtils;
import change.lottoMission.lotto.util.LottoNumberGenerator;
import change.lottoMission.lotto.util.LottoValidator;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/lottos")
public class LottoSpringController {


    @GetMapping()
    public String showLottos(Model model) {
        model.addAttribute("purchaseMoney", new PurchaseMoney());
        return "lottos/purchase";
    }

    @PostMapping()
    public String purchaseLottos(@ModelAttribute @Validated PurchaseMoney purchaseMoney,
                                 BindingResult bindingResult,
                                 HttpSession session) {

        if (purchaseMoney.getMoney() >= 1000 && purchaseMoney.getMoney() % 1000 != 0) {
            bindingResult.reject("purchaseMoney", new Object[]{purchaseMoney.getMoney()}, null);
        }
        if (bindingResult.hasErrors()) {
            return "lottos/purchase";
        }
        //여기서 검증을 했으니까 이제 입력받은 돈을 나눠서 생성한뒤에 모델에 담아서 뷰로 넘겨줘야한다.
        int purchaseQuantityReturn = CalculationUtils.purchaseQuantityReturn(purchaseMoney);
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchaseQuantityReturn; i++) {
            lottos.add(new Lotto(LottoNumberGenerator.lottoNumberReturn()));
        }
        session.setAttribute("lottos", lottos);
        return "redirect:/lottos/confirm";
    }

    @GetMapping("/confirm")
    public String lottosConfirm(Model model, HttpSession session) {
        List<Lotto> lottos = getLottos(session);
        if (lottos == null) {
            return "redirect:/lottos/purchase";
        }
        model.addAttribute("lottos", lottos);
        model.addAttribute("winningForm", new WinningForm());
        return "lottos/confirm";
    }

    @PostMapping("/confirm")
    public String purchaseLottosPrint(HttpSession session, @ModelAttribute @Validated WinningForm winningForm,
                                      BindingResult bindingResult, Model model) {
        List<Lotto> lottos = getLottos(session);
        if (lottos == null) {
            return "redirect:/lottos/purchase";
        }

        LottoValidator.validateBonusNumber(winningForm, bindingResult);
        LottoValidator.duplicateNumbers(winningForm.getNumbers(), bindingResult);

        if (bindingResult.hasErrors()) {
            model.addAttribute("lottos", lottos);
            return "lottos/confirm";
        }

        LottoManager lottoManager = new LottoManager(lottos, new Lotto(winningForm.getNumbers()),
                winningForm.getBonusNumber());
        Map<LottoRank, Integer> resultMap = lottoManager.calculateResults();
        model.addAttribute("resultMap", resultMap);

        int purchaseMoney = lottos.size() * 1000;
        double profitRate = printStatistics(resultMap, purchaseMoney);
        model.addAttribute("profitRate", profitRate);

        session.removeAttribute("lottos");
        return "lottos/result";
    }

    @GetMapping("/result")
    public String resultPrint() {

        return "lottos/result";
    }


    private double printStatistics(Map<LottoRank, Integer> resultMap, int purchaseMoney) {
        List<LottoRank> lottoRanks = getRanksForStatistics();

        long totalRewardMoney = 0;

        for (LottoRank lottoRank : lottoRanks) {
            int count = resultMap.get(lottoRank);
            if (count != 0) {
                totalRewardMoney += CalculationUtils.totalRewardMoney(lottoRank) * count;
            }
        }
        return CalculationUtils.calculateProfitRate(purchaseMoney, totalRewardMoney);
    }

    private static List<Lotto> getLottos(HttpSession session) {
        List<Lotto> lottos = (List<Lotto>) session.getAttribute("lottos");
        if (lottos == null || lottos.isEmpty()) {
            return null;
        }
        return lottos;
    }

    private List<LottoRank> getRanksForStatistics() {
        List<LottoRank> ranks = new ArrayList<>(List.of(LottoRank.values()));
        ranks.remove(LottoRank.MISS);
        return ranks.reversed();
    }
}
