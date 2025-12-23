package template.validation;

import java.util.List;

public class Validator {
    public static final String YES = "Y";
    public static final String NO = "N";

    protected Validator() {
    }

    // 입력 형식 검증: String -> int
    public static int validateNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.SHOULD_BE_NUMBER.getMessage());
        }
    }

    // 범위 검증 (min ~ max)
    public static void validateRange(int number, int min, int max) {
        if (number < min || number > max) {
            throw new IllegalArgumentException(ErrorMessage.SHOULD_BE_IN_RANGE.getMessage());
        }
    }

    // 양수 / 0 이상 검증
    public static void validatePositive(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException(ErrorMessage.SHOULD_BE_POSITIVE.getMessage());
        }
    }

    // 공백/빈 문자열 검증
    public static void validateNotBlank(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.SHOULD_NOT_BE_BLANK.getMessage());
        }
    }

    // 정수 리스트 중복 검증
    public static void validateIntegerListDistinct(List<Integer> values) {
        long distinctCount = values.stream().distinct().count();
        if (distinctCount != values.size()) {
            throw new IllegalArgumentException(ErrorMessage.SHOULD_BE_DISTINCT.getMessage());
        }
    }

    // 문자열 리스트 중복 검증
    public static void validateStringListDistinct(List<String> values) {
        long distinctCount = values.stream().distinct().count();
        if (distinctCount != values.size()) {
            throw new IllegalArgumentException(ErrorMessage.SHOULD_BE_DISTINCT.getMessage());
        }
    }

    // 배수 검증 (ex. 1000원 단위)
    public static void validateMultipleOf(int value, int unit) {
        if (value % unit != 0) {
            throw new IllegalArgumentException(ErrorMessage.SHOULD_BE_MULTIPLE_OF_UNIT.getMessage());
        }
    }

    // Y/N 입력 검증
    public static void validateYesOrNo(String input) {
        String trimmedInput = input.trim().toUpperCase();
        if (!trimmedInput.equals(YES) && !trimmedInput.equals(NO)) {
            throw new IllegalArgumentException(ErrorMessage.SHOULD_BE_Y_OR_N.getMessage());
        }
    }

    // 정규식 입력 검증 (기능 선택 등)
    // ex) 예를 들어, 기능 선택 메뉴에서 1,2,3,Q 같은 번호나 문자만 들어와야 하는 경우 regex인자에 [123Q]를 보내면 된다.
    public static String validateMatches(String input, String regex) {
        if (!input.matches(regex)) {
            throw new IllegalArgumentException(ErrorMessage.SHOULD_MATCH_REGEX.getMessage());
        }
        return input;
    }
}
