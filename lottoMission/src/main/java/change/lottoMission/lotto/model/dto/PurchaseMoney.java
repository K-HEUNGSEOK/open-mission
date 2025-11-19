package change.lottoMission.lotto.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

@Getter
@Setter
public class PurchaseMoney {
    @NotNull
    @Range(min = 1000, max = 100000)
    int money;

    public PurchaseMoney(int money) {
        this.money = money;
    }

    public PurchaseMoney() {
    }
}
