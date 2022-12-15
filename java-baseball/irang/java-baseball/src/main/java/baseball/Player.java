package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Integer> numList = new ArrayList<>();

    public Player() {

    }

    public void input() {
        List<Integer> num = new ArrayList<>();

        System.out.print("세자리 숫자를 입력해주세요: ");
        String str = Console.readLine();

        for (int i = 0; i < str.length(); i++) {
            num.add(str.charAt(i) - '0');
        }

        if (isValidation(num)) {
            this.numList = num;
        }
    }

    public List<Integer> getNumList() {
        return this.numList;
    }

    private boolean isValidation(List<Integer> list) {
        if (list.size() != 3) return false;
        if (list.get(0) == list.get(1) || list.get(0) == list.get(2) || list.get(1) == list.get(2)) return false;

        return true;
    }
}
