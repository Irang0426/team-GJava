package lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.Strings.PURCHASE_NUM;

public class Lottery {
    private List<Lotto> lottery = new ArrayList<>();

    public Lottery() {
    }

    public void createLottery(int num){
        System.out.printf(PURCHASE_NUM,num);
        for (int i = 0; i < num; i++) {
            lottery.add(Lotto.creatLotto());
        }
    }
    public void showLottery(){
        for (int i = 0; i < lottery.size(); i++) {
            System.out.println(lottery.get(i));
        }
    }
    public int size(){
        return lottery.size();
    }

    public Lotto get(int num){
        return lottery.get(num);
    }
}