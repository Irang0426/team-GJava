package baseball;

import java.util.ArrayList;
import java.util.List;

public class Referee {

    public Referee() {
    }

    public static List<Integer> CompareNums(List computerNums, List userNums){
        List<Integer> count = new ArrayList<>();

        int strike = CountStrike(computerNums,userNums);
        int sameNums = ContainNums(computerNums,userNums);

        count.add(strike);
        count.add(sameNums - strike);

        return count;
    }

    private static int CountStrike(List computerNums, List userNums){
        int strike = 0;
        for (int i = 0; i < computerNums.size() ; i++) {
            if(computerNums.get(i) == userNums.get(i)){
                strike++;
            }
        }
        return strike;
    }

    private static int ContainNums(List computerNums, List userNums){
        int sameNums = 0;

        for (int i = 0; i < computerNums.size() ; i++) {
            if(userNums.contains(computerNums.get(i))){
                sameNums++;
            }
        }
        return sameNums;
    }
}
