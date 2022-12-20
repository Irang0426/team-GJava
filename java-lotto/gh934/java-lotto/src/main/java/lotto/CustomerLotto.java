package lotto;

import java.util.ArrayList;
import java.util.List;

public class CustomerLotto {
    //로또를 입력받아서 여러개를 저장 하기위한 객체
    private List<Lotto> lottoList = new ArrayList<>();
    private int money = 0;


    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public void addLottoList(Lotto lotto) {
        this.lottoList.add(lotto);
    }

    public int getMoney() {
        return money;
    }

    public void addMoney(int money) {
        this.money += money;
    }

    public void showLottoList(int i) {
        System.out.println(lottoList.get(i).toString());
    }
}
