package template.view;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class OutputView {
    private static final String BULLET = "- ";
    private static final String COLON_SPACE = ": ";
    private static final String PIPE = " | ";
    private static final String LINE = "---------------------------------------";

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printXXX() {
        System.out.println(".......");
    }

    // 원화(돈) 형식을 맞춰주는 메서드
    // ex) 1000원 -> "1,000원"
    private String formatNumber(int amount) {
        return NumberFormat.getNumberInstance(Locale.KOREA).format(amount) + "원";
    }

    // 두 자리 숫자 형식으로 맞춰주는 메서드
    // ex) 3 -> 03
    private String formatTwoDigits(int value) {
        return String.format("%02d", value);
    }

    // 좌측 정렬(고정 폭)
    // ex) padRight("A", 3) -> "A  "
    protected String padRight(String text, int width) {
        String safe = String.valueOf(text);
        if (safe.length() >= width) return safe;
        return safe + " ".repeat(width - safe.length());
    }

    // 우측 정렬(고정 폭)
    // ex) padLeft("7", 3) -> "  7"
    protected String padLeft(String text, int width) {
        String safe = String.valueOf(text);
        if (safe.length() >= width) return safe;
        return " ".repeat(width - safe.length()) + safe;
    }

    // 퍼센트 포맷(소수점 n자리)
    // ex) formatPercent(0.1234, 1) -> "12.3%"
    protected String formatPercent(double ratio, int scale) {
        double percent = ratio * 100.0;
        return String.format("%." + scale + "f%%", percent);
    }

    // "네/아니오" 같은 출력이 필요할 때
    protected String formatYesOrNo(boolean value) {
        return value ? "네" : "아니오";
    }

    // List를 한 줄로 합치기 (출력에서 자주 씀)
    protected String joinWithPipe(List<String> parts) {
        return String.join(PIPE, parts);
    }
}
