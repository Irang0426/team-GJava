package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static baseball.Strings.INPUTNUMS;



public class User {
    private static List<Integer> inputs;

    public User() {
    }

    public static void input(){
        inputs = new ArrayList<>();
        System.out.print(INPUTNUMS);
        String nums = Console.readLine();

        for (int i = 0; i<nums.length(); i++) { // 입력받은 숫자를 리스트에 나누어 입력함
            inputs.add(i,Character.getNumericValue(nums.charAt(i))); // 자동 형변환으로 아스키코드가 입력되지 않도록 함
        }
        if(isValid(inputs) == false){
            throw new IllegalArgumentException();
        }
    }

    private static boolean isValid(List inputs){
        HashSet<Integer> inputHashSet = new HashSet<>(inputs); // 중복값 제거를 위해 해쉬셋에 입력
        if(inputHashSet.size() != 3 || inputs.size() != 3){ // 해쉬셋 혹은 리스트의 요소가 3개가 아닌 경우 false
            return false;
        }
        return true;
    }

    public static List<Integer> getInputs() {
        return inputs;
    }
}
