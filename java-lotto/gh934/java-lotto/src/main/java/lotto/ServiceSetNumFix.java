package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.Application.*;

public class ServiceSetNumFix {

    public static void run() {
        int money;
        money = getCustomerMoney();
        customerLotto.addMoney(money);
        while (!(money == 0)) {
            customerLotto.addLottoList((setRandomNumbers()));
            money -= 1000;
        }
        setWinNumber();
        // WINNINGNUMBERS = getWinNumber(); 로 하려했는데 trycatch때문에 길어져서 매서드하나를 만들었다
        BONUSNUMBER = getBonusNumber();
    }

    private static Lotto setRandomNumbers() {
        List<Integer> numbers;
        while (true) {
            numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
//            Collections.sort(numbers);
//            numbers.sort(Comparator.naturalOrder());
            numbers.stream().sorted().collect(Collectors.toList());
            return new Lotto(numbers);

        }
    }


    private static int getCustomerMoney() {
        System.out.println("사용하실 금액을 입력해 주세요 (1000원 단위로 입력해 주세요)");
        while (true) {
            String input = Console.readLine();
            if (!(input.matches("^[0-9]+$"))) {
                System.out.println("숫자만 입력해 주세요");
                continue;
            }
            if (Integer.parseInt(input) % 1000 == 0) {
                System.out.println(input + "원 입력 받았습니다.");
                return Integer.parseInt(input);
            }
            System.out.println("1000원 단위로 다시 입력해 주세요");
        }
    }

    private static Lotto getWinNumber() {
        System.out.println("당첨번호 1~45 범위의 숫자 6개를 ','로 구별해서 입력해 주세요");
        String input;
        input = Console.readLine();
        if (!(input.matches("^([0-9 ]+,){5}+[0-9]+$"))) {
            throw new IllegalArgumentException("숫자 6개 ','구별해서 입력해주세요");
        }
        String[] splitinput = input.split(",");
        List<Integer> lottoNumber = new ArrayList<>();
        for (int i = 0; i < splitinput.length; i++) {
            lottoNumber.add(Integer.parseInt(splitinput[i]));
        }
        lottoNumber.sort(Comparator.naturalOrder());
        return new Lotto(lottoNumber);
    }

    private static void setWinNumber() {
        while (true) {
            try {
                WINNINGNUMBERS = getWinNumber();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("로또 규격에 맞게 입력 해 주세요.");
            }
        }
    }

    private static int getBonusNumber() {
        System.out.println("보너스숫자를 입력해 주세요");
        while (true) {
            String input = Console.readLine();
            if (!(input.matches("^[0-9]+$"))) {
                continue;
            }
            if (!(Integer.parseInt(input) >= 1 && Integer.parseInt(input) < 45)) {
                continue;
            }
            if (!(WINNINGNUMBERS.getNumbers().contains(Integer.parseInt(input)))) {
                return Integer.parseInt(input);
            }
            System.out.println("다시 입력해 주세요");
        }
    }
}