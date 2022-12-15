package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<String> duplicateKeyword = new ArrayList<>();

        findDuplicateKeyword(forms, duplicateKeyword);
        sortDuplicationByKeyword(forms, answer, duplicateKeyword);


        return answer;
    }

    public static void findDuplicateKeyword(List<List<String>> forms, List<String> duplicateKeyword) { // 2회 이상 중복으로 나타나는 키워드를 해쉬셋에 저장함
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < forms.size(); i++) {
            String getNickName = forms.get(i).get(1); // 중복으로 사용되기에 가독성을 위해 변수로 정의함

            for (int j = 0; j < getNickName.length() - 1; j++) {
                String keyword = ""; // 키워드 저장을 위한 String 선언
                int count = 0; // 중복 횟수를 확인하기 위한 int 선언

                keyword += getNickName.charAt(j);
                keyword += getNickName.charAt(j + 1); // 비교를 위한 두글자를 keyword 변수에 입력

                for (int k = 0; k < forms.size(); k++) {
                    if (forms.get(k).get(1).contains(keyword)) { // 중복으로 사용된 키워드를 확인할때마다 count를 증가함
                        count++;
                    }
                }
                if (count > 1) { // 중복 횟수가 2회 이상인 경우 중복이 발생한 것으로 판단, 해쉬셋에 저장함
                    set.add(keyword); // 중복이 허용되지 않는 해쉬셋이기에 여러번 입력되더라도 자동으로 제거됨
                } // 중복 횟수가 1회 이하인 keyword는 for문의 시작으로 돌아가 초기화됨
            }
        }
        duplicateKeyword.addAll(set); // 저장한 해쉬셋을 리스트에 입력함
    }

    public static void sortDuplicationByKeyword(List<List<String>> forms, List<String> answer, List<String> duplicateKeyword) {
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < duplicateKeyword.size(); i++) { // 중복된 키워드의 갯수만큼 반복함
            for (int j = 0; j < forms.size(); j++) {
                if (forms.get(j).get(1).contains(duplicateKeyword.get(i))) { // 중복된 키워드를 포함하는 경우
                    set.add(forms.get(j).get(0)); // 해쉬셋에 이메일 주소 저장
                }
            }

        }
        answer.addAll(set); // 이메일 해쉬셋을 answer에 입력
        answer.sort(Comparator.naturalOrder()); // 입력된 이메일을 오름차순으로 정렬함
    }
}
//    public static boolean isValid(List<List<String>> forms){
//        if(forms.size() < 1 || forms.size() > 10000){ // 크루원의 인원 제한사항 확인
//            return false;
//        }
//        for (int i = 0; i < forms.size(); i++) {
//            if(forms.get(i).get(0).length()<10 ||forms.get(i).get(1).length()> 20){ // 이메일 길이 제한사항 확인
//                return false;
//            }
//            if(!(forms.get(i).get(0).contains("@email.com"))){ // 도메인 제한사항 확인
//                return false;
//            }
//            if(forms.get(i).get(1).length() < 1|| forms.get(i).get(1).length() > 20){ // 닉네임 길이 제한사항 확인 (한글만 가능은 구현 못했음)
//                return false;
//            }
//        }
//        return true;
//    }
//}

//https://hianna.tistory.com/582 ArrayList 정렬
//https://hianna.tistory.com/582 List 중복 제거 방법