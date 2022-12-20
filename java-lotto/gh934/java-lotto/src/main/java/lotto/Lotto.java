package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int NUMBER_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException("번호는 6개만 가능합니다");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> nonDunplicateNumbers = new HashSet<>(numbers);
        if (nonDunplicateNumbers.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException("번호들은 중복 될 수 없습니다.");
        }

    }

    private void validateRange(List<Integer> numbers) {
        for (int i = 0; i < NUMBER_SIZE; i++) {
            if (!(numbers.get(i) >= 1 && numbers.get(i) <= 45)) {
                throw new IllegalArgumentException("범위밖의 숫자 입니다.");
            }
        }

    }

    public int compare(List<Integer> lottoNumber) {
        int count = 0;
        for (int i = 0; i < lottoNumber.size(); i++) {
            if (numbers.contains(lottoNumber.get(i))) {
                count++;
            }
        }
        return count;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return "" + numbers;
    }

}
