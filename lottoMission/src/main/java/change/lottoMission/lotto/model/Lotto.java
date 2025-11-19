package change.lottoMission.lotto.model;

import change.lottoMission.lotto.util.LottoValidator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        List<Integer> copyNumbers = new ArrayList<>(numbers);
        Collections.sort(copyNumbers);
        this.numbers = copyNumbers;
    }

    private void validate(List<Integer> numbers) {
        LottoValidator.validateNumbers(numbers);
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(this.numbers);
    }

    public boolean containsNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
