package change.lottoMission.lotto.util;

public enum ErrorMessage {
    INVALID_NUMBER_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자만 가능합니다"),
    INVALID_NUMBER_FORMAT("[ERROR] 입력은 숫자(int)만 가능합니다."),
    INVALID_NUMBER_COUNT("[ERROR] 로또 번호는 6개여야 합니다."),
    INVALID_DUPLICATE_NUMBERS("[ERROR] 중복된 숫자가 있습니다."),
    INVALID_AMOUNT_MIN("[ERROR] 최소 주문 금액은 1000원 입니다."),
    INVALID_AMOUNT_MAX("[ERROR] 1인당 최대 주문 금액은 100_000원 입니다."),
    INVALID_AMOUNT_UNIT("[ERROR] 1000원 단위로 구입이 가능합니다."),
    DUPLICATE_BONUS_NUMBER("[ERROR] 보너스 번호와 당첨 번호가 중복되었습니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
