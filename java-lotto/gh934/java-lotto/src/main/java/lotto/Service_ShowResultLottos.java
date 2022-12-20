package lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.Application.*;

public class Service_ShowResultLottos {
    public static void run() {
        int[] resultOfWin = {0, 0, 0, 0, 0};             // [3개당첨갯수, 4개당첨갯수, 5개당첨갯수,5+보너스,6개당첨갯수]
        for (int i = 0; i < resultOfWin.length; i++) {
            resultOfWin[i] = numberOfResult(i);
        }
        showWinReslut(resultOfWin);
        showRateOfReturn(resultOfWin);

    }

    private static void showWinReslut(int[] resultOfWin) {
        String[] write = {"3개 일치 (5,000원) - ", "4개 일치 (50,000원) - ", "5개 일치 (1,500,000원) - "
                , "5개 일치, 보너스 볼 일치 (30,000,000원) - ", "6개 일치 (2,000,000,000원) - "};
        for (int i = 0; i < resultOfWin.length; i++) {
            System.out.println(write[i] + resultOfWin[i] + "개");
        }

    }

    private static void showRateOfReturn(int[] resultOfWin) {
        double totalPay = 0;
        double[] price = {5_000, 50_000, 1_500_000, 30_000_000, 2_000_000_000};
        double money = customerLotto.getMoney();
        double rateOfReturn;
        for (int i = 0; i < resultOfWin.length; i++) {
            totalPay += price[i] * resultOfWin[i];
        }
        rateOfReturn = totalPay * 100 / money;
        System.out.println("총 수익률은 " + Math.round(rateOfReturn * 10) / 10.0 + "%입니다.");
    }


    private static int numberOfResult(int num) {
        //0입력받으면 3개 당첨, 1 -4개, 2 - 5개, 3 - 5개+보너스 , 4 - 6개
        // [3개당첨 몇개, ~~~~, 6개당첨 몇개]로 만들들어서 리턴하려 했는데 들여쓰기 이렇게 됬다.. 다른방법 나중에 찾아보자.
        List<Integer> checkWin = checkWin();
        int count = 0;
        int[] check = {3, 4, 5, 10, 6};                  // 5개+ 보너스를 임의값 10으로 표현했다.
        for (int i = 0; i < checkWin.size(); i++) {
            if (checkWin.get(i) == check[num]) {
                count++;
            }
        }

        return count;
    }

    private static List<Integer> checkWin() {            // [당첨갯수, 당첨갯수,당첨갯수,.....(로또 발급갯수만큼)] 정상작동
        List<Integer> checkWin = new ArrayList<>();
        int check = 0;
        for (int i = 0; i < customerLotto.getLottoList().size(); i++) {
            check = WINNINGNUMBERS.compare(customerLotto.getLottoList().get(i).getNumbers());
            if (check == 5) {
                checkWin.add(checkBounus(i));           // 5개+보너스번호이면 10으로 리턴, 아니면 5로 리턴
                continue;
            }
            checkWin.add(check);
        }

        return checkWin;
    }

    private static int checkBounus(int num) {
        if (customerLotto.getLottoList().get(num).getNumbers().contains(BONUSNUMBER)) {
            return 10;
        }
        return 5;
    }

}
