package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Executor {
    private Player player;
    private Computer computer;
    private Referee referee;

    public Executor() {
        this.player = new Player();
        this.computer = new Computer();
        this.referee = new Referee();
    }

    public void startGame() {
        System.out.println("게임을 시작합니다.");   // 문자열 하드코딩X 분리
        computer.setRandom();
        while (true) {
            player.input();
            List<Integer> list = referee.findCount(player.getNumList(), computer.getAnswer());

            if (list.get(1) == 3) {
                System.out.println("정답입니다!");
                break;
            } else if (list.get(0) == 0 && list.get(1) == 0) {
                System.out.println("낫싱");
            } else if (list.get(0) == 0 && list.get(1) != 0) {
                System.out.printf("%d스트라이크\n", list.get(1));
            } else if (list.get(0) != 0 && list.get(1) == 0) {
                System.out.printf("%d볼\n", list.get(0));
            } else {
                System.out.printf("%d볼 %d스트라이크\n", list.get(0), list.get(1));
            }
        }
        System.out.println("게임을 재시작하시겠습니까? 1: 재시작 2: 종료");
        String str = Console.readLine();
        if (str.equals("1")) {
            startGame();
        }
    }
}
