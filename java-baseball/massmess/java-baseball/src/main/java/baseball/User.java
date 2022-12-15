package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {


    static List<Integer> NumList() {

        String inputNum = Console.readLine();

        List<Integer> NumList = new ArrayList<>();
        for (int i = 0; i < inputNum.length(); i++) {
            char currentChar = inputNum.charAt(i);
            int currentNum = currentChar-'0';
            NumList.add(currentNum);
        }
        return NumList;
    }
}
