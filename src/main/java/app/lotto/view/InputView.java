package app.lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static app.lotto.validation.InputViewValidator.*;

public class InputView {

    private static final int LOTTERY_NUMBER_COUNT = 6;
    private static final int LOTTERY_NUMBER_MIN = 1;
    private static final int LOTTERY_NUMBER_MAX = 45;
    private static final int PRICE_OF_LOTTERY = 1000;

    private static final Scanner sc = new Scanner(System.in);

    public static int readAmount() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            int amount = Integer.parseInt(sc.nextLine());
            validateAmountUnit(amount, PRICE_OF_LOTTERY);
            return amount;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readAmount();
        }
    }

    public static List<Integer> readWinningNumbers() {
        try {
            System.out.println("당첨 번호를 입력해 주세요.");
            String[] input = sc.nextLine().split(",");

            validateNumbersCount(input, LOTTERY_NUMBER_COUNT);
            List<Integer> winningNumbers = getWinningNumbers(input);

            validateNumbersRange(winningNumbers, LOTTERY_NUMBER_MIN, LOTTERY_NUMBER_MAX);
            return winningNumbers;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readWinningNumbers();
        }
    }

    private static List<Integer> getWinningNumbers(String[] input) {
        return Arrays.stream(input)
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }
}