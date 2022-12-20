package lotto;

import static lotto.Application.customerLotto;

public class Service_ShowLottos {
    public static void run() {
        System.out.println(customerLotto.getMoney() / 1000 + "개를 구매했습니다.");
        for (int i = 0; i < customerLotto.getLottoList().size(); i++) {
            customerLotto.showLottoList(i);
        }
    }
}
