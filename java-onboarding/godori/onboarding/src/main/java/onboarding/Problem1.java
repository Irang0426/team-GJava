package onboarding;

import java.util.ArrayList;
import java.util.List;


class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;


        int pobiScore = getScore(pobi);
        int crongScore = getScore(crong);

        //값비교

        if (pobiScore == -1 || crongScore == -1) return -1;
        if (pobiScore > crongScore) return 1;
        else if (pobiScore < crongScore) return 2;
        else return 0;


    }

    //제한사항
    private static int getScore(List<Integer> arr) {

        if (!(arr.get(0) >= 1 && arr.get(0) <= 400) || !(arr.get(1) >= 1 && arr.get(1) <= 400))
            return -1;

        if (arr.get(0) % 2 == 0 || arr.get(1) % 2 != 0)
            return -1;

        if (arr.get(0) + 1 == arr.get(1))
            return -1;

        return 0;
    }

}