package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static lotto.Prize.*;
import static lotto.Strings.*;

public class Calculator {


    private double profit = 0.0;

    public Calculator() {
    }
    
    public void compareWinningNums(Lottery lottery, Lotto winningNums, int bonus){
        for (int i = 0; i < lottery.size(); i++) {
            switch(lottery.get(i).compare(winningNums)){
                case 6 : addPrizeHashMap(FIRST_PRIZE);
                    break;
                case 5 : if(lottery.get(i).contain(bonus)){
                    addPrizeHashMap(SECOND_PRIZE);
                    break;
                }
                    addPrizeHashMap(THIRD_PRIZE);
                    break;
                case 4 : addPrizeHashMap(FORTH_PRIZE);
                    break;
                case 3 : addPrizeHashMap(FIFTH_PRIZE);
                    break;
                default: break;
            }
        }
    }
    
    public void showWinnings(){
        System.out.printf(SHOW_WINNINGS,
                showPrizeHashMap(FIFTH_PRIZE),showPrizeHashMap(FORTH_PRIZE),
                showPrizeHashMap(THIRD_PRIZE),showPrizeHashMap(SECOND_PRIZE),showPrizeHashMap(FIRST_PRIZE));
    }

    public void calcProfit(int purchase){
        profit = Math.round(((double)calcReword() / purchase*10000))/100.0;
    }

    public void showProfit(){
        System.out.printf(SHOW_PROFIT,profit);
    }


}
