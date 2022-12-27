package lotto;

public class User {

    private int purchase = 0;
    private Lottery lottery;
    private Calculator calculator;

    public User() {
        lottery = new Lottery();
        calculator = new Calculator();
    }

    public void purchaseLottery() {
        purchase = Input.inputPurchase();
        lottery.createLottery(purchase / 1000);
        lottery.showLottery();
    }

    public void calcProfit(Lotto winningNums, int bonus){

        calculator.compareWinningNums(lottery, winningNums, bonus);
        calculator.showWinnings();
        calculator.calcProfit(purchase);
        calculator.showProfit();
    }

}
