package change.lottoMission.lotto.model.dto;

import change.lottoMission.lotto.model.Lotto;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
public class WinningForm {
    @NotNull
    @Size(min = 6, max = 6)
    private List<@Range(min = 1, max = 45) Integer> numbers;
    @NotNull
    @Range(min = 1, max = 45)
    private Integer bonusNumber;

    public WinningForm(List<Integer> numbers, Integer bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public WinningForm() {
        this.numbers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            numbers.add(null);
        }
    }
}
