package onboarding;

import java.util.ArrayList;

public class Problem4 {
    static ArrayList<Character> alphabetLower = new ArrayList<Character>();
    static ArrayList<Character> reverseAlphabetLower = new ArrayList<Character>();
    static ArrayList<Character> alphabetUpper = new ArrayList<Character>();
    static ArrayList<Character> reverseAlphabetUpper = new ArrayList<Character>();
    static ArrayList<Character> motherWord = new ArrayList<Character>();

    public static String solution(String word) {
        String answer = "";

        if (word.length() < 1 || word.length() > 1000) { // 제한 사항에 따라 문자열의 길이에 대한 유효성 검사
            return "Error";
        }

        toArrayList(word); // 알파벳 대/소문자를 각 배열에 순서에 맞게 입력함(엄마 말씀 변환을 위해 매개변수 word 입력)

        answer = toFrogWord(motherWord); // 엄마의 말을 청개구리의 말로 변환하여 answer에 입력

        return answer; // 결과값을 반환함
    }

    public static void toArrayList(String word) {
        for (int i = 0; i < 26; i++) { // 소문자 알파벳 정방향으로 배열(alphabetLower) 입력
            char alp = 'a';
            alphabetLower.add(i, (char) (alp + i));
        }

        for (int i = 0; i < 26; i++) { // 소문자 알파벳 역방향으로 배열(reverseAlphabetLower) 입력
            char alp = 'z';
            reverseAlphabetLower.add(i, (char) (alp - i));
        }


        for (int i = 0; i < 26; i++) { // 대문자 알파벳 정방향으로 배열(alphabetUpper) 입력
            char alp = 'A';
            alphabetUpper.add(i, (char) (alp + i));
        }

        for (int i = 0; i < 26; i++) { // 대문자 알파벳 역방향으로 배열(reverseAlphabetUpper) 입력
            char alp = 'Z';
            reverseAlphabetUpper.add(i, (char) (alp - i));
        }

        for (int i = 0; i < word.length(); i++) { // 엄마 말씀(word)을 배열(motherWord)로 나누어 입력
            motherWord.add(word.charAt(i));
        }

    }

    public static String toFrogWord(ArrayList<Character> motherWord) {

        ArrayList<Character> frogWord = new ArrayList<Character>();
        String translatedWord = "";

        for (int i = 0; i < motherWord.size(); i++) {
            int num = 0;

            if (alphabetLower.contains(motherWord.get(i)) == true) {// i번째 문자가 소문자인 경우
                num = alphabetLower.indexOf(motherWord.get(i)); // i번째 문자가 몇번째 알파벳인지 확인
                frogWord.add(reverseAlphabetLower.get(num));    // 역순의 알파벳에서 동일한 순서의 알파벳으로 변환, 입력

            } else if (alphabetUpper.contains(motherWord.get(i)) == true) {// i번째 문자가 대문자인 경우
                num = alphabetUpper.indexOf(motherWord.get(i)); // i번째 문자가 몇번째 알파벳인지 확인
                frogWord.add(reverseAlphabetUpper.get(num));    // 역순의 알파벳에서 동일한 순서의 알파벳으로 변환, 입력

            } else {                                            // i번째 문자가 대/소문자 모두 아닌 경우
                frogWord.add(motherWord.get(i));                // 영문자가 아니므로 변환하지 않고 입력
            }
        }


        for (int i = 0; i < frogWord.size(); i++) {           // 위 for문에서 변환된 청개구리의 말을 String으로 전환함
            translatedWord += frogWord.get(i);
        }
        return translatedWord;
    }

}
