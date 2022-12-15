package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;


public class Problem6 {
    public static List<String> solution (List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    //닉네임 두글자씩 나누는 함수
    public static List<String> makeNewnickname(String nickname){
        List<String> new_nickname = new ArrayList<>();

        for(int i=0;i<nickname.length()-1;i++){
            String temp = "";
            temp+=nickname.charAt(i);
            temp+=nickname.charAt((i+1));
            new_nickname.add(temp);
        }

        return new_nickname;
    }
    // 기능 목록 2 : 두 글자로 나눠진 닉네임이 포함된 이메일을 구하는 함수
    public static List<List<String>> getemailOfnickname(Set<String> nickname_set, List<List<String>> forms){
        List<List<String>> duplicationemail = new ArrayList<>();

        for(String nickname:nickname_set){
            List<String> temp = new ArrayList<>();
            for(List<String> form:forms){
                if(form.get(1).contains(nickname)){
                    temp.add(form.get(0));
                }
            }
            duplicationemail.add(temp);
        }

        return duplicationemail;
    }
}
