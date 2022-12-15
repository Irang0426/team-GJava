package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobi_L = pobi.get(0);
        int pobi_R = pobi.get(1);
        int crong_L = crong.get(0);
        int crong_R = crong.get(1);

        int num1 = compare(sum(dividePageNumber(pobi_L)),sum(dividePageNumber(pobi_R)));
        int num2 = compare(mul(dividePageNumber(pobi_L)),mul(dividePageNumber(pobi_R)));
        int num3 = compare(sum(dividePageNumber(crong_L)),sum(dividePageNumber(crong_R)));
        int num4 = compare(mul(dividePageNumber(crong_L)),mul(dividePageNumber(crong_R)));

        if(pobi_R-pobi_L !=1 ||crong_R-crong_L !=1){
            answer = -1;
        }
        else if ((compare(num1,num2)==compare(num3,num4))){
            answer = 0;
        }
        else if((compare(num1,num2)>compare(num3,num4))){
            answer = 1;
        }
        else{
            answer = 2;
        }

        return answer;
    }

    public static List<Integer> dividePageNumber(int pageNumber){
        int num= pageNumber;
        List<Integer> dividedPageNumber = new ArrayList<>();

            while(num>0) {
                dividedPageNumber.add(num % 10);
                num = num/10;
            }
            return dividedPageNumber;
    }

    public static int sum(List<Integer> divpage){
        int sum = 0;

        for(int i = 0 ; i<divpage.size() ; i++){
            sum += divpage.get(i);
        }
        return sum;
    }

    public static int mul(List<Integer> divpage){
        int mul = 1;

        for(int i = 0; i<divpage.size(); i++){
            mul *= divpage.get(i);
        }
        return mul;
    }

    public static int compare(int num_1, int num_2){
        if(num_1>num_2){
            return num_1;
        }
        else {
            return num_2;
        }
    }
}