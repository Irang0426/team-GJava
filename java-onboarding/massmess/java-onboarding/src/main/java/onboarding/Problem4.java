package onboarding;

public class Problem4 {
//    public static String solution(String word) {
//        String answer = "";
//
//
//      for(int i=0; i<word.length(); i++){
////            if(word.charAt(i) >= 'A' && word.charAt(i)<='Z'){
////                answer += (char)('Z' - (word.charAt(i)-'A'));
////            }  for(
//            else if(word.charAt(i) >= 'a' && word.charAt(i)<='z'){
//                answer += (char)('z' - (word.charAt(i)-'a'));
//            }
//            else
//                answer += word.charAt(i);
//        }
//        return answer;

    public static String solution(String word) {
        String answer = "";
        StringBuffer sb = new StringBuffer(); //새로운 문자열 생성하기 위해 StringBuffer 사용

        for (int i = 0; i < word.length(); i++) {
            char alphabet = word.charAt(i); //String 타입을 charAt()을 사용하여 chat 타입으로 변환
            alphabet = reverseAlphabet(alphabet); //알파벳 역으로 변환 시켜주고
            sb.append(alphabet); //StiringBuffer sb에 문자 추가해줌
        }
        answer = sb.toString(); // 문자열로 다시 만들어줌
        return answer;

    }

    // 알파벳을 반대쪽 알파벳으로 변환해주는 함수 reverseAlphabet()
    private static char reverseAlphabet(char alphabet) {
        if (Character.isLowerCase(alphabet)) {
            return (char) ('z' - alphabet + 'a');
        }
        else if (Character.isUpperCase(alphabet)) {
            return (char) ('Z' - alphabet + 'A');
        }
        else {
            return alphabet; //알파벳 대문자 소문자 아닐 경우 그냥 그대로 리턴
        }

    }
}
