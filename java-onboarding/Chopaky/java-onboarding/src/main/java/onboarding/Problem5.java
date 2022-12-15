package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    static int [] currency;

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        if (money < 1 || money > 1000000) {
            return answer; // 유효성 검사를 통과하지 못하면 빈 리스트를 반환함
        }

        return calcCurrency(money); // 통화의 갯수를 확인하여 리턴
    }

    public static List<Integer> calcCurrency(int money) {
        List<Integer> answer = new ArrayList<>(); // 답안 작성을 위한 ArrayList 생성
        currency = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1}; // currency 배열에 통화 단위를 높은 수부터 입력

        for (int i = 0; i < currency.length; i++) {
            int j = money / currency[i]; // i번째 통화로 나눌 수 있는 횟수를 j에 저장

            answer.add(j); // int간의 사칙연산이므로 정수만을 반환, answer에 순서대로 저장함
            money -= currency[i] * j; // 통화로 전환된 만큼 money에서 차감하여 반복
        }
        return answer;
    }
}