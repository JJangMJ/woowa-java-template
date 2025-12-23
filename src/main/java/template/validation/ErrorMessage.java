package template.validation;

public enum ErrorMessage {
    //공통
    SHOULD_BE_NUMBER("숫자로 입력해야 합니다."),
    SHOULD_BE_IN_RANGE("허용 범위를 벗어났습니다."),
    SHOULD_BE_POSITIVE("양수만 입력할 수 있습니다."),
    SHOULD_NOT_BE_BLANK("입력이 비어있습니다."),
    SHOULD_BE_DISTINCT("중복되지 않는 값들로만 이루어져야 합니다."),
    SHOULD_BE_MULTIPLE_OF_UNIT("입력 값은 지정된 단위의 배수여야 합니다."),
    INVALID_INPUT("유효하지 않은 입력입니다. 다시 입력해 주세요."),
    SHOULD_MATCH_REGEX("입력 형식이 올바르지 않습니다."),
    SHOULD_BE_Y_OR_N("Y 또는 N만 입력할 수 있습니다.");

    private final static String ERROR_MESSAGE_HEADER = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_MESSAGE_HEADER + message;
    }
}
