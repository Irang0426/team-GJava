package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Referee {


    public Referee() {
    }

    public List<Integer> findCount(List<Integer> playerList, List<Integer> computerList) {
        final int NUM_SIZE = 3;
        final int ADD_SIZE = 6;
        Set<Integer> set = new HashSet<>();
        List<Integer> countList = new ArrayList<>();

        int ball;
        int strike = 0;

        for (int i = 0; i < NUM_SIZE; i++) {
            if (playerList.get(i) == computerList.get(i)) {
                strike++;
            }
        }

        for (int i = 0; i < NUM_SIZE; i++) {
            set.add(playerList.get(i));
            set.add(computerList.get(i));
        }
        ball = ADD_SIZE - set.size() - strike;

        countList.add(ball);
        countList.add(strike);

        return countList;
    }
}
