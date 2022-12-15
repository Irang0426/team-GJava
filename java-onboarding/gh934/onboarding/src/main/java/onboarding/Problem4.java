package onboarding;

public class Problem4 {


    public static String solution(String word) {
        if(!(word.length() >=1 && word.length() <=1000 ))           // 1~~1000 사이
            return "error";


        return wordChange(word);
    }

   private static String wordChange(String word){
        char[] chars = word.toCharArray();                   //String을 char[]로 쪼개기

        for(int i=0 ; i< chars.length; i++) {               // a입력시  z-a +a  = z   z입력시  z -z +a =a b입력시 z-b+a = z-1(y)
            if (chars[i] >= 'a' && chars[i] <= 'z') {
                chars[i] = (char) ('z' - chars[i] + 'a');
            }
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                chars[i] = (char) ('Z' - chars[i] + 'A');
            }
        }

        return String.valueOf(chars);                       //다시 String 으로 바꿔서 리턴
    }


}

