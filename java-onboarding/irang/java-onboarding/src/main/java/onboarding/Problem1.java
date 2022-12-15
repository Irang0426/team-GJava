package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
//    public static void main(String[] args) {
//        List<Integer> pobi = new ArrayList<>();
//        List<Integer> crong = new ArrayList<>();
//        pobi.add(131);
//        pobi.add(132);
//        crong.add(211);
//        crong.add(212);
//        int pobiScore = compare(pobi);
//        int crongScore = compare(crong);
//
//        int answer = versus(pobiScore, crongScore);
//        System.out.println(answer);
//    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (pobi.get(1) - pobi.get(0) == 1 && crong.get(1) - crong.get(0) == 1) {
            int pobiScore = compare(pobi);
            int crongScore = compare(crong);

            return versus(pobiScore, crongScore);
        }
        return -1;
    }

    // 각 자릿수 덧셈
    public static int sum(int num) {
        return (num / 100) + ((num / 10) % 10) + (num % 10);
    }

    // 각 자릿수 곰셈
    public static int mul(int num) {
        if (num < 100) {
            return (num / 10) * (num % 10);
        } else if (num < 10) {
            return (num % 10);
        } else {
            return (num / 100) * ((num / 10) % 10) * (num % 10);
        }
    }

    // 값 비교
    public static int compare(List<Integer> list) {
        List<Integer> calcList = new ArrayList<>();

        calcList.add(sum(list.get(0)));
        calcList.add(sum(list.get(1)));
        calcList.add(mul(list.get(0)));
        calcList.add(mul(list.get(1)));

        int max = 0;
        for (int i = 0; i < calcList.size(); i++) {
            if (max < calcList.get(i)) {
                max = calcList.get(i);
            }
        }
        return max;
    }

    // 승부 후 결과 값 반환
    public static int versus(int pobi, int crong) {
        if (pobi > crong) {
            return 1;
        } else if (pobi < crong) {
            return 2;
        } else if (pobi == crong) {
            return 0;
        } else {
            return -1;
        }
    }
}