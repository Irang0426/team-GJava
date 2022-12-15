package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        answer = delCode(cryptogram);

        while (isValid(answer)) {
            answer = delCode(answer);
        }
        return answer;
    }

    public static boolean isValid(String cryptogram) {
        for (int i = 0; i < cryptogram.length(); i++) {
            if (cryptogram.length() < 1 || cryptogram.length() > 1000) {
                return false;
            } else if (cryptogram.toLowerCase().equals(cryptogram)) {
                return true;
            } else if
            (cryptogram.charAt(i) == cryptogram.charAt(i - 1)) {
                return true;
            }
        }
            return false;
    }
       public static String delCode (String cryptogram){
        String answer = "";
        boolean dec = false;

           for (int i = 0; i < cryptogram.length()-1; i++) {
               if (cryptogram.charAt(i) != cryptogram.charAt(i+1)){
                   if (dec) {
                       dec = false;
                       continue;
                   }
                   answer += cryptogram.charAt(i);
               }else
               {
                   dec = true;
               }
           }
           return answer;
       }
}
