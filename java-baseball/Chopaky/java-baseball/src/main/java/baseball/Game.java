package baseball;

import java.util.ArrayList;
import java.util.List;

import static baseball.Strings.*;

public class Game {
    public Game() {
        Computer computer = new Computer();
        Referee referee = new Referee();
        User user = new User();
    }

    public void StartGame(){
        List<Integer> count = new ArrayList<>();
        Computer.createNums();

        while(true) {
            User.input();
            count = Referee.CompareNums(Computer.getNums(), User.getInputs());

            Announcing(count);
            if (count.get(0) == 3) { // 전부 맞춘 경우
                System.out.print(OUT);
                return;
            }
            if (count.get(0) == 0 && count.get(1) == 0) { // 모두 틀린 경우
                System.out.println(NOTIHNG);
            }
        }
    }
    private void Announcing(List<Integer> count){
        if(count.get(1) != 0){
            System.out.printf(BALL,count.get(1));
        }
        if(count.get(0) != 0){
            System.out.printf(STRIKE,count.get(0));
        }
    }
}
