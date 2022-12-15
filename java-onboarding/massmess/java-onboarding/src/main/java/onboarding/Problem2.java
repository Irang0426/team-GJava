package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {

        String answer = checkCryptogram(cryptogram);
        return answer;
    }
    public static String checkCryptogram(String cryptogram) {

        String crypto = cryptogram;

        while(true){

            int crypto_len = crypto.length();

            if (crypto_len <= 1) {
                return crypto; // 문자열 길이가 1 이다.
            } else if (crypto_len == 2)

            {
                return getString(crypto);
            }else {
                crypto = removeCrypto(crypto);

                if(checkLeft(crypto)){
                    // 전부 다른 경우
                    return crypto ;
                }

            }
        }
    }

    private static String getString(String crypto) {
        if (crypto.charAt(0) == crypto.charAt(1))
        {
            return "";
        }
        else {
            return crypto;
        }
    }

    // crypto의 길이가 3 이상인 경우만을 처리합니다. // 단 한 번만 줄여서 반환 합니다

    public static  String removeCrypto(String crypto){

        /// 배열 초기 index 로 접근

        String[] al = crypto.split(""); //문자열 배열로 나눠주고
        int n = al.length;
        int[] check_list =  new int[n];
        List<String> result = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            if (al[i - 1].equals(al[i])) {
                check_list[i-1] = 1;
                check_list[i] = 1;
            }
        }

        for (int i = 0; i < n; i++) {
            if (check_list[i] == 0 ){
                result.add(al[i]);
            }
        }

        if(result.isEmpty()){
            return "";
        }
        else {
            return String.join("", result);
        }
    }

    // checkSame char


    public static  Boolean checkLeft(String cryptogram){


        //중복 문자열이 있으면 false 를 반환

        String[] al = cryptogram.split("");

        for (int i = 1; i < al.length; i++) {
            if (al[i - 1].equals(al[i])) {
                return false;
            }

        }
        // 남은 문자열의 내용이 전부 다른 경우
        return true;
    }
}