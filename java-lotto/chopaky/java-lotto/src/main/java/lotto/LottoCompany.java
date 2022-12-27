package lotto;

import static lotto.Strings.*;

public class LottoCompany {
    private Lotto winningNum;
    private int bonus;

    public LottoCompany() {

    }

    public Lotto setWinningNums(){
        System.out.println(SET_WINNINGNUMS);
        winningNum = new Lotto(Input.inputWinningNum());
        return winningNum;
    }

    public int setBonus(){
        System.out.println(SET_BONUS);
        bonus = Input.inputBonus();

        if(winningNum.contain(bonus)){
            System.out.println(BONUS_ALREADY_CONTAINED);
            throw new IllegalArgumentException();
        }
        return bonus;
    }

    public Lotto getWinningNum() {
        return winningNum;
    }

    public int getBonus() {
        return bonus;
    }
}
