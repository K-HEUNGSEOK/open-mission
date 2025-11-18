package change.lottoMission.lotto.view;


import java.util.Scanner;

public class InputView {
    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_MESSAGE = "당첨번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스번호를 입력해 주세요.";

    public String enterPurchaseAmount(Scanner scanner) {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        return scanner.nextLine();
    }

    public String winningNumberInput(Scanner scanner) {
        System.out.println(WINNING_NUMBER_MESSAGE);
        return scanner.nextLine();
    }

    public String bonusNumberInput(Scanner scanner) {
        System.out.println(BONUS_NUMBER_MESSAGE);
        return scanner.nextLine();
    }
}
