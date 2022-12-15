package baseball;

import camp.nextstep.edu.missionutils.Console;

import static baseball.Strings.*;

public class Application {
    private static int answer = 1;
    public static void main(String[] args) {

        while(answer == 1) {
            Game game = new Game();
            System.out.println(START);
            game.StartGame();
            System.out.println(GAMEOVER);
            answer = Restart();
        }
    }

    private static int Restart(){
        System.out.println(RESTART);
        String input = Console.readLine();
        int answer = Character.getNumericValue(input.charAt(0));
        if(input.length() != 1 || answer > 2){
            throw new IllegalArgumentException();
        }
        return answer;
    }
}
