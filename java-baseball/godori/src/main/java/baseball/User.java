package baseball;

import camp.nextstep.edu.missionutils.Console;

public class User {
  public String getUserNum() {
    System.out.println("숫자를 입력하세요:");
    String input = Console.readLine();
    checkNumber(input);
    checkLength(input);
    checkSameNum(input);
    return input;
  }

  public void checkLength(String input) {
    if (input.length() != 3) {
      throw new IllegalArgumentException("3자리 수를 입력하세요.");
    }
  }

  public void checkSameNum(String input) {
    if ((input.charAt(0) == input.charAt(1))
        || (input.charAt(1) == input.charAt(2))
        || (input.charAt(0) == input.charAt(2))
    ) {
      System.out.println("서로 다른 3자리의 수를 입력하세요.");
    }
  }

  public void checkNumber(String input) {
    for (int index = 0; index < input.length(); index++) {
      char inputDigit = input.charAt(index);
      if (Character.isDigit(inputDigit) == false) {
        System.out.println("숫자를 입력하세요.");
      }

    }
  }
}
