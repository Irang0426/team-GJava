package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        int[] won = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        if (!(money >= 1 && money <= 1000000)) {
            System.out.println("부자시네요. 돈이 너무 많습니다.");
        }

        return getChange(money, won);
    }

    public static List<Integer> getChange(int money, int[] won) {
        List<Integer> moneyArr = new ArrayList<>();

        for (int i = 0; i < won.length; i++) {
            if (money >= won[i]) {
                moneyArr.add(money / won[i]);
                money %= won[i];
            } else {
                moneyArr.add(0);
            }
        }

        return moneyArr;
    }
}
