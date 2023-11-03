package lotto.Domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class Lotto {

    public static final String INVALID_SIZE_MESSAGE = "[ERROR] 6개의 숫자를 입력해야 합니다.";
    public static final String DUPLICATE_MESSAGE = "[ERROR] 로또 번호에 중복된 값이 있습니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateUnique(numbers);
        this.numbers = numbers;
    }

    private void validateUnique(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<Integer>();
        if (hasDuplicate(numbers, uniqueNumbers)) {
            throw new IllegalArgumentException(DUPLICATE_MESSAGE);
        }
    }

    private static boolean hasDuplicate(List<Integer> numbers, Set<Integer> uniqueNumbers) {
        return !numbers.stream().allMatch(number -> uniqueNumbers.add(number));
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_SIZE_MESSAGE);
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
