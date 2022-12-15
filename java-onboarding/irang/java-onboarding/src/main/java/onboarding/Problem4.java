package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem4 {
    public static String solution(String word) {
        return isConversion2(word);
    }

    public static String isConversion(String str) {
        int alphaNum = 26;
        List<String> upper = new ArrayList<>();
        List<String> lower = new ArrayList<>();
        List<String> upper_reverse = new ArrayList<>();
        List<String> lower_reverse = new ArrayList<>();

        for (int i = 0; i < alphaNum; i++) {
            upper.add(String.valueOf((char)('A' + i)));
            upper_reverse.add(String.valueOf((char)('Z' - i)));
            lower.add(String.valueOf((char)('a' + i)));
            lower_reverse.add(String.valueOf((char)('z' - i)));
        }

        char[] conArr = str.toCharArray();

        StringBuilder sb = new StringBuilder();

        int index;

        for (int i = 0; i < conArr.length; i++) {
            if (conArr[i] >= 'A' && conArr[i] <= 'Z') {
                index = upper.indexOf(String.valueOf(conArr[i]));
                sb.append(upper_reverse.get(index));
            } else if (conArr[i] >= 'a' && conArr[i] <= 'z') {
                index = lower.indexOf(String.valueOf(conArr[i]));
                sb.append(lower_reverse.get(index));
            } else {
                sb.append(conArr[i]);
            }
        }
        return sb.toString();
    }

    public static String isConversion2(String str) {
        char[] ch = str.toCharArray();

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] >= 'a' && ch[i] <= 'z') {
                ch[i] = (char)('z' - ch[i] + 'a');
            } else if (ch[i] >= 'A' && ch[i] <= 'Z') {
                ch[i] = (char)('Z' - ch[i] + 'A');
            }
        }
        return String.valueOf(ch);
    }
}
