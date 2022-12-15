package onboarding;

import org.assertj.core.util.Arrays;

import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        if (!(isValid(cryptogram))) {
            return "ERROR";
        }

        return getDetoxify(cryptogram);
    }

    public static boolean isValid(String str) {
        if (!(str.length() > 0 && str.length() <= 1000)) {
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            if (!(str.charAt(i) >= 'a' && str.charAt(i) <= 'z')) {
                return false;
            }
        }

        return true;
    }

    public static String getDetoxify(String str) {
        String[] strArr = str.split("");
        List<Object> strList = Arrays.asList(strArr);

        int count = 0;
        while (count < strList.size() - 1) {
            if (strList.get(count).equals(strList.get(count + 1))) {
                strList.remove(count);
                strList.remove(count);
                count = 0;
            } else {
                count++;
            }
        }

        String result = "";
        for (Object list : strList) {
            result += String.valueOf(list); // 리스트를 문자열로 변환
        }

        return result;
    }
}
