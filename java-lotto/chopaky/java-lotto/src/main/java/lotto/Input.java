package lotto;

import camp.nextstep.edu.missionutils.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static lotto.Strings.*;

public class Input {

    private static String input;

    public static int inputPurchase(){
        int purchase;

        System.out.print(INPUT_MONEY);
        input = Console.readLine();

        if(!(isPattern(numPattern))) {
            System.out.println(NOT_INT);
            throw new IllegalArgumentException();
        }

        purchase = Integer.parseInt(input);
        if(purchase % 1000 != 0){ // 1000원 단위가 아닌 경우
            System.out.println(PURCHASE_RANGE_OVER);
            throw new IllegalArgumentException();
        }
        return purchase;
    }


    public static int inputBonus(){
        int bonus;

        input = Console.readLine();

        if(!(isPattern(numPattern))) {
            System.out.println(NOT_INT);
            throw new IllegalArgumentException();
        }

        bonus = Integer.parseInt(input); // 입력값을 int로 변환
        if(bonus < 1 || bonus >45){ // 입력 값이 범위를 벗어나는 경우
            System.out.println(LOTTO_RANGE_OVER);
            throw new IllegalArgumentException();
        }
        return bonus;
    }

    public static List<Integer> inputWinningNum(){
        input = Console.readLine();

        if(!(isPattern(lottoPattern))){
            System.out.println(NOT_LOTTO_PATTERN);
            throw new IllegalArgumentException();
        }

        List<String> inputs = Arrays.asList(input.split(",")); // String List에 분할입력

        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < inputs.size(); i++) { // 분할한 List를 ParseInt하여 입력
            nums.add(Integer.parseInt(inputs.get(i)));
        }
        return nums;
    }

    private static boolean isPattern(String pattern){
        if(Pattern.matches(pattern,input)){
            return true;
        }
        return false;
    }


}
