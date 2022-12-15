package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int num1;
        int num2 = randomNum();
        int[] score = {0, 0};
        while (!(score[0] == 3)) {

            num1 = setNum();
            if (error(num1) == false) {
                System.out.println("다시입력하세요");
                continue;
            }
            score = numCompare(num1, num2);
            showInfo(score);
            if (score[0] == 3) {                  //나중에 인덴트 줄이기
                if (restart()) {
                    score[0] = 0;
                    num2 = randomNum();
                }
            }
        }

    }


    public static int setNum() {
        System.out.printf("Num =  ");
        int num = Integer.parseInt(Console.readLine());

        return num;
    }

    public static boolean error(int num) {              //에러체크 100~999 , 같은 숫자 있는지, 0이 들어가 있는지
        //나중에 정규표현식으로 숫자만 입력받게 다시 짜기
        int[] errorCheck = setNumArr(num);
        if (!(num >= 100 && num <= 999)) {
            return false;
        } else if (errorCheck[0] == errorCheck[1] || errorCheck[1] == errorCheck[2] || errorCheck[0] == errorCheck[2]) {
            return false;
        } else if (errorCheck[0] == 0 || errorCheck[1] == 0 || errorCheck[2] == 0) {
            return false;
        } else {
            return true;
        }
    }


    public static int[] setNumArr(int num) {            //숫자를 배열에 하나씩 쪼개서 넣어주는 기능
        int[] numArr = new int[3];
        for (int i = 0; i < 3; i++) {
            numArr[i] = num % 10;
            num = num / 10;
        }
        return numArr;
    }


    public static int[] numCompare(int num1, int num2) {
        int[] numArr1 = setNumArr(num1);
        int[] numArr2 = setNumArr(num2);
        int[] score = {0, 0};                //score[0] strike   score[1] ball
        for (int i = 0; i < 3; i++) {
            if (numArr1[i] == numArr2[i]) {
                score[0]++;
            }
            if (numArr1[i] == numArr2[0]) {                   //5
                score[1]++;
            } else if (numArr1[i] == numArr2[1]) {             //4
                score[1]++;
            } else if (numArr1[i] == numArr2[2]) {             //1
                score[1]++;
            }
        }
        score[1] = score[1] - score[0];
        return score;

    }

    public static void showInfo(int[] score) {
        if (score[0] == 0 && score[1] == 0) {         //strike ball 둘다 0일때, strike만 있을때, ball만있을때, 전부있을때
            System.out.println("낫싱");
        } else if (score[1] == 0) {
            System.out.println(score[0] + "스트라이크");
        } else if (score[0] == 0) {
            System.out.println(score[1] + "볼");
        } else {
            System.out.println(score[1] + "볼" + score[0] + "스트라이크");
        }
    }

    public static boolean restart() {

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        while (true) {
            int num = Integer.parseInt(Console.readLine());
            if (num == 1) {
                return true;
            } else if (num == 2) {
                return false;
            } else {
                System.out.println("다시 입력해 주세요.");
//                throw new IllegalArgumentException();
            }
        }

    }

    public static int randomNum() {
        int num = 0;
        while (error(num) == false) {
            num = Randoms.pickNumberInRange(100, 999);
        }
        return num;
    }
}

