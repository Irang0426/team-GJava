package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Service_SetNum {
    // 문제를 잘못 이해하고 만든 기능   사용하지 않지만 고생한 흔적으로 삭제하지 않고 남겨뒀다
   /* public static final int BONUSNUMBER = Randoms.pickNumberInRange(1, 45);
    public static final Lotto WINNINGNUMBERS = new Lotto(setWinningNumbers());
    public static CustomerLotto customerLotto = new CustomerLotto();

    public static void run() {
        int money;
        money = getCustomerMoney();
        customerLotto.addMoney(money);
        while (!(money == 0)) {
            try {
                System.out.println(money / 1000 + "번 남았습니다.");
                customerLotto.addLottoList(getCustomerLotterNumber());
            } catch (IllegalArgumentException e) {
                System.out.println("정확한 범위로 다시 입력해 주세요");
                money += 1000;
            }
            money -= 1000;
        }
    }

    private static List<Integer> setWinningNumbers() {
        List<Integer> numbers;
        while (true) {
            numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            if (!numbers.contains(BONUSNUMBER)) {
                numbers.sort(Comparator.naturalOrder());
                return numbers;
            }
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
                System.out.println(input);
                return Integer.parseInt(input);
            }
            System.out.println("1000원 단위로 다시 입력해 주세요");
        }
    }

    private static Lotto getCustomerLotterNumber() {
        System.out.println("1~45 범위의 숫자 6개를 ','로 구별해서 입력해 주세요");
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
*/
}
