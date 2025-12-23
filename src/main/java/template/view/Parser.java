package template.view;

import camp.nextstep.edu.missionutils.DateTimes;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import template.validation.Validator;

public class Parser {

    protected Parser() {
    }

    // 1. String -> Int 변환
    public static int parseInt(String input) {
        Validator.validateNotBlank(input);
        return Validator.validateNumber(input);
    }

    // 2. 특정 구분자로 문자열을 나누어 반환
    public static List<String> splitByDelimiter(String input, String delimiter) {
        Validator.validateNotBlank(input);
        return Arrays.stream(input.split(delimiter))
                .map(String::trim)
                .filter(splitInput -> !splitInput.isEmpty())
                .toList();
    }

    // 3. 임의의 구분자로 구분된 숫자 문자열을 List<Integer>로 변환
    public static List<Integer> parseIntsByDelimiter(String input, String delimiter) {
        return splitByDelimiter(input, delimiter).stream()
                .map(Validator::validateNumber)
                .toList();
    }

    // 4. "이름-숫자" 같은 패턴에서 [이름, 숫자] 두 조각으로 나누는 예시
    // * 예: "A-3" -> ["A", "3"]
    public static String[] splitPair(String input, String separator) {
        Validator.validateNotBlank(input);
        String[] splitInput = input.split(separator);
        return Arrays.stream(splitInput)
                .map(String::trim)
                .toArray(String[]::new);
    }

    // 5. "yyyy-MM-dd HH:mm" 형식의 문자열을 LocalDateTime으로 변환
    public static LocalDateTime parseDateTimeToLocalDateTime(String input) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return LocalDateTime.parse(input, formatter);
    }

    // 6. "yyyy-MM-dd" 형식의 문자열을 LocalDateTime으로 변환
    public static LocalDateTime parseDateToLocalDateTime(String input) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(input, formatter);
        LocalTime time = DateTimes.now().toLocalTime();
        return LocalDateTime.of(date, time);
    }

    // 6. "HH:mm" 형식의 문자열을 LocalDateTime으로 변환
    public static LocalDateTime parseTimeToLocalDateTime(String input) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalDate date = DateTimes.now().toLocalDate();
        LocalTime time = LocalTime.parse(input, formatter);
        return LocalDateTime.of(date, time);
    }

    // 7. LocalDateTime을 "yyyy-MM-dd HH:mm"으로 변환
    public static String formatDateTime(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return dateTime.format(formatter);
    }

    // 8. LocalDateTime을 "yyyy-MM-dd"으로 변환
    public static String formatDate(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return dateTime.toLocalDate().format(formatter);
    }

    // 9. LocalDateTime을 "HH:mm"으로 변환
    public static String formateTime(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return dateTime.toLocalTime().format(formatter);
    }
}
