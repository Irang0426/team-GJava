package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private static List<Integer> nums;

    public Computer() {
    }

    public static void createNums(){
        nums = new ArrayList<>();

        while (nums.size() < 3) {// 3개의 숫자를 만들때까지 반복
            int randomNumber = Randoms.pickNumberInRange(1, 9); // 0이 나오지 않도록 1~9 사이의 숫자를 생성
            if (!nums.contains(randomNumber)) { // 중복된 숫자가 아닌 경우
                nums.add(randomNumber); // 생성한 숫자를 추가함
            }
        }
    }

    public static List<Integer> getNums() {
        return nums;
    }
}

