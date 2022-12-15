package onboarding;

import java.util.List;
import java.util.*;

class Problem1_1 {

    public static void main(String[] args) {

        int pageNumber = 8;

        List<Integer> pageNumberArray = new ArrayList();

            while (pageNumber > 0) {
                pageNumberArray.add(pageNumber % 10);
                pageNumber /= 10;

            }
        System.out.println(pageNumberArray);

        }




    }
