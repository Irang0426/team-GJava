package onboarding;

import java.util.List;

public class Problem6Test {

    public static void main(String[] args) {
        List<List<String>> forms = List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("pdw1@email.com", "박동원"),
                List.of("pdw2@email.com", "동원박"),
                List.of("pdw3@email.com", "원동박"),
                List.of("nowm@email.com", "이제엠")
        );
        Problem6.solution(forms);

        System.out.println(Problem6.solution(forms));
    }
}
