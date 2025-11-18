package change.lottoMission.lotto.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidator {
    private LottoValidator() {
    }

    public static List<Integer> parseWinningNumbers(String inputMessage) {
        List<Integer> numbers = new ArrayList<>();
        String[] splitMessage = inputMessage.split(",");

        for (String splitString : splitMessage) {
            int number = parseNumber(splitString.trim());
            numbers.add(number);
        }
        return numbers;
    }

    public static int parseNumber(String inputMessage) {
        try {
            return Integer.parseInt(inputMessage);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
        }
    }

    public static void validateAmount(int number) {
        amountMin(number);
        amountMax(number);
        amountUnit(number);
    }

    public static void validateNumbers(List<Integer> numbers) {
        numberCount(numbers);
        numberRange(numbers);
        duplicateNumbers(numbers);
    }

    public static void validateBonusNumber(List<Integer> numbers, int bonusNumber) {
        numberRange(bonusNumber);
        for (Integer number : numbers) {
            if (number == bonusNumber) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS_NUMBER.getMessage());
            }
        }
    }

    private static void amountMin(int number) {
        if (number < 1000) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT_MIN.getMessage());
        }
    }

    private static void amountMax(int number) {
        if (number > 100_000) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT_MAX.getMessage());
        }
    }

    private static void amountUnit(int number) {
        if (number % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT_UNIT.getMessage());
        }
    }


    private static void numberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            numberRange(number);
        }
    }

    private static void numberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_RANGE.getMessage());
        }
    }

    private static void numberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_COUNT.getMessage());
        }
    }

    private static void duplicateNumbers(List<Integer> numbers) {
        Set<Integer> numberValidation = new HashSet<>();
        for (Integer number : numbers) {
            if (!numberValidation.add(number)) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_DUPLICATE_NUMBERS.getMessage());
            }
        }
    }


}
