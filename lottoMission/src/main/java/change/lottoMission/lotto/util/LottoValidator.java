package change.lottoMission.lotto.util;

import change.lottoMission.lotto.model.dto.WinningForm;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.validation.BindingResult;

public class LottoValidator {
    private LottoValidator() {
    }

    public static void validateBonusNumber(WinningForm winningForm, BindingResult bindingResult) {
        if (winningForm.getNumbers().contains(winningForm.getBonusNumber())) {
            bindingResult.reject("bonusNumberMismatch");
        }
    }

    public static void duplicateNumbers(List<Integer> numbers, BindingResult bindingResult) {
        Set<Integer> numberValidation = new HashSet<>();
        for (Integer number : numbers) {
            if (!numberValidation.add(number)) {
                bindingResult.reject("numbersDuplicate");
                return;
            }
        }
    }


}
