package lotto;

import java.util.*;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

import static lotto.Strings.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        numbers = numbers.stream().sorted().collect(Collectors.toList());
        validate(numbers);
        this.numbers = numbers;
    }
    
    public static Lotto creatLotto(){
        Lotto lotto;

        while (true){
            List<Integer> randomLotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            HashSet<Integer> duplicateChecker = new HashSet<>(randomLotto);
            if(duplicateChecker.size() == 6){
                lotto = new Lotto(randomLotto);
                break;
            }
        }
        return lotto;
    }

    public int compare(Lotto winningNums){
        int sameNums = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if(winningNums.contain(numbers.get(i))){
                sameNums++;
            }
        }
        return sameNums;
    }

    public boolean contain(int num){
        return numbers.contains(num);
    }

    private void validate(List<Integer> numbers) {
        HashSet<Integer> duplicateChecker = new HashSet<>(numbers);

        if (duplicateChecker.size() != 6) { // 중복 번호에 대한 체크
            System.out.println(DUPLICATE_LOTTO_NUMS);
            throw new IllegalArgumentException();
        }
        for (int i = 0; i <numbers.size(); i++) { // 로또 번호 범위에 대한 체크
            if(numbers.get(i) < 1 || numbers.get(i) > 45){
                System.out.println(LOTTO_RANGE_OVER);
                throw new IllegalArgumentException();
            }
        }
    }


    @Override
    public String toString() {
        return ""+ numbers;
    }

}
