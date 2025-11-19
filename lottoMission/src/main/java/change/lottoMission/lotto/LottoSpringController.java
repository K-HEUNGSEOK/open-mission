package change.lottoMission.lotto;

import change.lottoMission.lotto.model.Lotto;
import change.lottoMission.lotto.model.dto.PurchaseMoney;
import change.lottoMission.lotto.util.CalculationUtils;
import change.lottoMission.lotto.util.LottoNumberGenerator;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
@RequestMapping("/lottos")
public class LottoSpringController {


    @GetMapping()
    public String showLottos(Model model){
        model.addAttribute("purchaseMoney", new PurchaseMoney());
        return "lottos/purchase";
    }

    @PostMapping()
    public String purchaseLottos(@ModelAttribute @Validated PurchaseMoney purchaseMoney,
                                 BindingResult bindingResult,
                                 RedirectAttributes attributes){

        if (purchaseMoney.getMoney() >= 1000 && purchaseMoney.getMoney() % 1000 != 0){
            bindingResult.reject("purchaseMoney",new Object[]{purchaseMoney.getMoney()}, null);
        }
        if (bindingResult.hasErrors()){
            return "lottos/purchase";
        }
        //여기서 검증을 했으니까 이제 입력받은 돈을 나눠서 생성한뒤에 모델에 담아서 뷰로 넘겨줘야한다.
        int purchaseQuantityReturn = CalculationUtils.purchaseQuantityReturn(purchaseMoney);
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0 ; i < purchaseQuantityReturn; i ++){
            lottos.add(new Lotto(LottoNumberGenerator.lottoNumberReturn()));
        }
        attributes.addFlashAttribute("lottos",lottos);
        return "redirect:/lottos/confirm";
    }
}
