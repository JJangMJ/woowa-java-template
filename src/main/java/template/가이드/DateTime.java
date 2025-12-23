package template.가이드;

import camp.nextstep.edu.missionutils.DateTimes;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTime {
    private static final DateTimeFormatter DATE_FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter TIME_FMT = DateTimeFormatter.ofPattern("HH:mm");
    private static final DateTimeFormatter DATETIME_FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    private DateTime() {}

    // "yyyy-MM-dd" 형식의 문자열을 LocalDate 형식으로 변환
    public static LocalDate parseDate(String input) {
        return LocalDate.parse(input, DATE_FMT);
    }

    // "HH:mm" 형식의 문자열을 LocalTime 형식으로 변환
    public static LocalTime parseTime(String input) {
        return LocalTime.parse(input, TIME_FMT);
    }

    // "yyyy-MM-dd HH:mm" 형식의 문자열을 LocalDateTime 형식으로 변환
    public static LocalDateTime parseDateTime(String input) {
        return LocalDateTime.parse(input, DATETIME_FMT);
    }

    // "HH:mm" 형식의 문자열을 LocalDate를 오늘로 설정하여 LocalDateTime 형식으로 변환
    public static LocalDateTime parseTimeToday(String input) {
        return LocalDateTime.of(DateTimes.now().toLocalDate(), parseTime(input));
    }

    // "yyyy-MM-dd" 형식의 문자열을 LocalTime을 현재 시간으로 설정하여 LocalDateTime 형식으로 변환
    public static LocalDateTime parseDateStartOfDay(String input) {
        return parseDate(input).atStartOfDay();
    }

    // 몇 분 차이인지 계산
    public static long diffMinutes(LocalDateTime from, LocalDateTime to) {
        return ChronoUnit.MINUTES.between(from, to);
    }

    // 며칠 차이인지 계산
    public static long diffDays(LocalDate from, LocalDate to) {
        return ChronoUnit.DAYS.between(from, to);
    }

    // "yyyy-MM-dd" 형식을 문자열로 변환
    public static String formatDate(LocalDate date) {
        return date.format(DATE_FMT);
    }

    // "HH:mm" 형식을 문자열로 변환
    public static String formatTime(LocalTime time) {
        return time.format(TIME_FMT);
    }

    // "yyyy-MM-dd HH:mm" 형식을 문자열로 변환
    public static String formatDateTime(LocalDateTime dateTime) {
        return dateTime.format(DATETIME_FMT);
    }
}
