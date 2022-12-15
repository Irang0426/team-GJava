package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        if(emailCheck(forms)==true) {
            answer = nameCheck(forms);

        }


        return answer;
    }



    public static boolean emailCheck(List<List<String>> forms) {
        if(!(forms.size()>=1 &&forms.size()<=10000)){                  //제한사항 1~1만명
            return false;
        }

        int count = 0;
        for(int i=0; i<forms.size(); i++){
            if(!(forms.get(i).get(0).length() >=11 && forms.get(i).get(0).length()< 20)){   //길이 11~20 확인
                return false;
            }

            StringBuilder check = new StringBuilder();
            for(int j = 0 ; j < forms.get(i).get(0).length(); j++){
                if (j>forms.get(i).get(0).length()-10){
                    check.append(forms.get(i).get(0).charAt(j));
                }
                if(check.toString().equals("email.com")){                // @email.com으로 끝나는지 확인
                    count++;                                            // 나중에 정규표현식 이용해서 짜보기
                }
            }
        }

        if(count == 0){
            return false;
        }else {
            return true;
        }
    }

    private static List<String> nameCheck(List<List<String>> forms){
        for (int i = 0; i < forms.size(); i++) {
            if(!(forms.get(i).get(1).length() >=1 && forms.get(i).get(0).length()< 20)){   //길이 1~20 확인
                System.out.println("에러");
            }
        }


        List<String> check =new ArrayList<>();                             // 2글자로 쪼개고 저장
        for(int i = 0; i<forms.size();i++){
            for (int j = 0; j < forms.get(i).get(1).length()-1 ; j++) {
                StringBuilder names = new StringBuilder();
                names.append(forms.get(i).get(1).charAt(j));
                names.append(forms.get(i).get(1).charAt(j+1));
                check.add(names.toString());
            }
        }
         check = check.stream().distinct().collect(Collectors.toList());
        List<String> duplicate = new ArrayList<>();
        for (int i = 0; i< check.size();i++){                       //어떤 단어가 중복인지 중복단어 체크
            int count = 0;
            for (int j =0;j<forms.size();j++){
                if(forms.get(j).get(1).contains(check.get(i))){
                    count++;
                }
            }
            if(count>1){
                duplicate.add(check.get(i));
            }
        }
        List<String> formsrReturn = new ArrayList<>();
        for(int i = 0; i<forms.size(); i++){
            int count = 0;
            for (int j = 0; j <duplicate.size();j++){
                if(forms.get(i).get(1).contains(duplicate.get(j))){
                    count++;
                }
            }
            if(count > 0){
                formsrReturn.add(forms.get(i).get(0));                  //중복있으면 추가.
            }
        }
        return formsrReturn.stream().sorted().collect(Collectors.toList());     //정렬해서 리턴
    }
}