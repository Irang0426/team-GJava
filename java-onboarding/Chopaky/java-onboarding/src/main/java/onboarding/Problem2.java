package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    static List<Character> cryptogramArr;

    public static String solution(String cryptogram) {
        cryptogramArr = new ArrayList<>();
        String answer = "answer";
        toArrayList(cryptogram); // String을 List로 분할입력

        if (validation(cryptogramArr) == false) { // 유효성 검사
            return "error";
        }

        answer = cryptography(cryptogramArr); // List로 분할된 cryptogram을 해석하여 String으로 반환

        return answer;
    }

    static boolean validation(List<Character> arr) {

        if (arr.size() < 1 || arr.size() > 1000) { // 문자열의 길이에 대한 유효성 검사
            return false;
        }
        for (int i = 0; i < arr.size(); i++) { // 문자열에 소문자 이외의 문자가 있는지 유효성 검사
            if (arr.get(i) < 96 || arr.get(i) > 122) {
                return false;
            }
        }
        return true;
    }

    static void toArrayList(String cryptogram) { // String으로 입력된 Cryptogram을 List로 한글자씩 입력
        for (int i = 0; i < cryptogram.length(); i++) {
            cryptogramArr.add(cryptogram.charAt(i));
        }
    }

    static String cryptography(List<Character> arr) {
        String str = "";

        for (int i = 1; i < arr.size(); i++) { //배열의 바깥 범위를 나타내지 않도록 i의 값은 1로 초기화
            if (arr.get(i - 1) == arr.get(i)) {//앞뒤의 값이 같은 경우 i번쨰, i-1번째 값을 모두 제거함
                arr.remove(i);
                arr.remove(i - 1);
                i = 0;  // 처음부터 다시 확인해야 하므로 i를 초기화함, 해당 문장 직후에 i++ 발생할 것이기에 결과적으로는 다시 1로 초기화됨
            }
        }

        for (int i = 0; i < arr.size(); i++) {// 해석한 Crptogram을 String으로 전환함
            str += arr.get(i);
        }
        return str;
    }


}
