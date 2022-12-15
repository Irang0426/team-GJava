package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        String check = " ";

        if (errorCheck(answer) == false){
            System.out.println("error");
        }else {
            while (!(answer.equals(check))) {       // check 와 answer을 비교
                check = answer;                     // check에 그전에 해독한 암호 대입
                answer = wordChange(check);         // 해독한 암호를 한번더 해독해서 answer에 대입
            }                                       // check 와 answer이 같으면 해독 할 것이 더이상 없으니까 빠져나온다.
        }                                           //  zyelleyz를 입력 받았으면
        return answer;                              //  check = zyelleyz         answer = zyeeyz
    }                                               //  check = zyeeyz           answer = zyyz
                                                    //  check = zyyz             answer = zz
                                                    //  check = zz               answer = " "
                                                    //  여기서 빠져나오는 것이 아니라
                                                    //  check = " "              answer = " "
                                                    //  이렇게 한번 더 해독하고 나오게 짜서 나중에 더생각해보기.




    private static boolean errorCheck(String word){
        if(!(word.length() >=1 && word.length() <=1000 ))           // 1~~1000 사이가 아니면 에러값 리턴
            return false;

        char[] chars = word.toCharArray();
        for(int i=0 ; i< chars.length; i++){                         // string을 char 로 쪼개섯
            if(!(chars[i] >= 'a' && chars[i] <= 'z')){               // 소문자가 아닌 것이 있으면 에러값 리턴
                return false;
            }
        }
        return true;
    }

    private static String wordChange(String word){
        char[] chars = word.toCharArray();                      //String을 char[]로 쪼개기
        StringBuilder charsChange = new StringBuilder();        //StringBuilder 사용
        for(int i=0 ; i< chars.length;i++ ) {                   //받은 문자열 길이 만큼 반복실행
            if(i== chars.length-1){                             //마지막 반복 char[chars.lenght-1]일때
                charsChange.append(chars[i]);                   //존재하지 않는 배열 char[chars.length]랑 비교하지 못하도록 함.
            }else
            if(!(chars[i] == chars[i+1])) {                     // 바로 옆 배열과 값이 같지 않다면(연속되지 않는다면)
                charsChange.append(chars[i]);                   // charsChange에 값을 추가
            }else  {                                            // 바로 옆 배열과 값이 같으면
                i++;                                            // i++해서 이번문자랑 다음문자 (char[i]랑 char[i+1]) 입력하지 않고 스킵
            }
        }

        return charsChange.toString();                       //다시 String 으로 바꿔서 리턴
    }
}
