package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        if(!(money>=1 && money<=1000000)){
            return Collections.emptyList();
        }
            List<Integer> answer = Collections.emptyList();
            answer = changeMoney(money);

        return answer;
    }
   /* public static List<Integer> changeMoney(int money) {
        List<Integer> change = new ArrayList<>();
        change.add(0,money/50000);
        money = money % 50000;
        change.add(1,money/10000);
        money = money %10000;
        change.add(2,money/5000);
        money = money % 5000;
        change.add(3,money/1000);
        money = money %1000;
        change.add(4,money/500);
        money = money %500;
        change.add(5,money/100);
        money = money %100;
        change.add(6,money/50);
        money = money %50;
        change.add(7,money/10);
        money = money %10;
        change.add(8,money);
        return change;
    }
}*/
  public static List<Integer> changeMoney(int money) {

        List<Integer> change = new ArrayList<>();
        int[] num = {50000,10000,5000,1000,500,100,50,10,1} ;
        for(int i=0;i<9;i++){
            change.add(i,money/num[i]);
            money= money % num[i];
        }

        return change;
    }
}
  /* public static List<Integer> changeMoney(int money) {
        List<Integer> change = new ArrayList<>();
        int j = 5;
        int i = 4;
        for (; i > 0; i--) {
            change.add(8 - (i + j - 1), money / (int)( Math.pow(2,i) * Math.pow(5,j)) );
            money = money % (int)( Math.pow(2,i) * Math.pow(5,j));
            j--;
            change.add(8 - (i + j - 1), money / (int)( Math.pow(2,i) * Math.pow(5,j)) );
            money = money % (int)( Math.pow(2,i) * Math.pow(5,j));
        }
        change.add(8 - (i + j - 1), money );
        return change;
    }
}*/
//   n번째 arraylist에 삽입       xx원 단위지폐가 몇개 필요한지
//      8-( i+j-1)              money /(2^i * 5^j)
//  8-( 4+5-1)= 8- 8 =0         money /(2^4 * 5^5)  = 50000
//  8-( 4+4-1)= 8- 7 =1         money /(2^4 * 5^4)  = 10000
//  8-( 3+4-1)= 8- 6 =2         money /(2^3 * 5^4)  = 5000
//  8-(3+3-1)= 8- 5 =3          money /(2^3 * 5^3)  = 1000
//  8-(2+3-1)= 8- 4 =4          money /(2^2 * 5^3)  = 500
//  8-(2+2-1)= 8- 3 =5          money /(2^2 * 5^2)  = 100
//  8-(1+2-1)= 8- 2 =6          money /(2^1 * 5^2)  = 50
//  8-(1+1-1)= 8- 1 =7          money /(2^1 * 5^1)  = 10
//   i= 0, j= 1;
//     for문 끝
//   change.add(8 - (i + j - 1), money );
// i>0으로 안끝내고 i>=0으로 끝내면
// for문 수행은 i=0, j=1  이랑  i=0, j=0 두가지 경우를 arraylist에 넣는 동작을 수행한다.
// 8-(0+1-1)   8-0= 8   money/(2^0 * 5^1)    5원짜리 동전이 추가되고
// 8-(0+0-1)   8+1= 9   money/(2^0 * 5^0)    1원짜리 동전이 그 다음 배열로 밀리기 때문에
// i>0 으로 끝내고 남은 값을 arraylist에 추가를 해주었다.