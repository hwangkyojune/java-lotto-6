package lotto;

import java.util.List;

public class ValidateService {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int NUMBER_SIZE = 6;
    public static void validateAuthorizedLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(
                    ErrorMessage.BOUND_LENGTH.getErrorMessage());
        }
    }

    public static void validateProperNumbers(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            int lottoNum = numbers.get(i);
            if (lottoNum < MIN_NUMBER && lottoNum > MAX_NUMBER) {
                throw new IllegalArgumentException(
                        ErrorMessage.NON_PROPER_NUMS.getErrorMessage()
                );
            }
        }
    }
    public static void validateDuplicatedNums(List<Integer> numbers) {
        int distinctNumbersCount = (int) numbers.stream().distinct().count();
        if (distinctNumbersCount != NUMBER_SIZE) {
            throw new IllegalArgumentException(
                    ErrorMessage.NON_DUPLICATED_NUMS.getErrorMessage()
            );
        }
    }

}
