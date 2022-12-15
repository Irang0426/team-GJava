package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        answer = Check(pobi,crong);
        if (answer ==-1) {
            return answer;
        }else
        {
                int[] compareP = new int[2];
                int[] compareC = new int[2];
                for(int i = 0; i<2; i++) {
                    compareP[i] = Math.max(sum(devide(pobi.get(i))),multi(devide(pobi.get(i))));
                    compareC[i] = Math.max(sum(devide(crong.get(i))),multi(devide(crong.get(i))));
                }
                answer = compare(compareP,compareC);
            }
        return answer;
    }
    public static int Check(List<Integer> pobi,List<Integer> crong) {
        if (pobi.get(0) - pobi.get(1) != -1 || crong.get(0) - crong.get(1) != -1) {                  //제한사항
            return -1;
        } else if (!(pobi.get(0) >= 1 && pobi.get(0) <= 399)) {
            return -1;
        } else if(! (crong.get(0) >= 1 && crong.get(0) <= 399)) {
            return -1;
        } else
            return 0;
    }

    public static int[] devide(int value) {
        int[] num = new int [3];
        for (int i = 0; i < 3; i++) {                           //pobiNum 배열에 pobi페이지 숫자 쪼개서 넣기
            num[i] = value % 10;                   // 98  입력시 [8][9][0]
            value= value/10;
        }
        return num;
    }
    public static int sum(int[] value) {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
                sum += value[i];
        }
        return sum;
    }
    public static int multi(int[] value) {
        int multi = 0;
            multi = (value[2] != 0) ? value[0] * value[1] * value[2] :value[0] * value[1];

        return multi;
    }
    public static int compare(int[] value1, int[] value2) {
        int num1 = 0;
            num1 = Math.max(value1[0], value1[1]);
        int num2 = 0;
            num2 = Math.max(value2[0], value2[1]);

        if (num1 == num2) {
            return  0;
        } else if (num1 > num2) {
            return  1;
        } else {
            return  2;
        }
    }
}
