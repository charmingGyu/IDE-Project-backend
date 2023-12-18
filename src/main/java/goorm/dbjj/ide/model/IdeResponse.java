package goorm.dbjj.ide.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@JsonPropertyOrder({"isSuccess", "message", "results"})
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Data
public class IdeResponse {
    private boolean isSuccess;
    private String message;
    private Object results;

    public static IdeResponse ok(Object response) {
        return new IdeResponse(true, "요청에 성공하셨습니다", response);
    }
}
