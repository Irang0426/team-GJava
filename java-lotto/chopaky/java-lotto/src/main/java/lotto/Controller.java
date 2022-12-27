package lotto;

import static lotto.Strings.ERROR;

public class Controller {

    private User user;
    private LottoCompany lottoCompany;
    public Controller() {
        user = new User();
        lottoCompany = new LottoCompany();
    }

    public void run(){
        try {
            user.purchaseLottery();
            user.calcProfit(lottoCompany.setWinningNums(), lottoCompany.setBonus());
        }catch(Exception e){
            System.out.println(ERROR);
        }
    }
}
