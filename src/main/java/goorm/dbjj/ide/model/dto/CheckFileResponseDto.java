package goorm.dbjj.ide.model.dto;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({"isSuccess", "message", "results"})
public class CheckFileResponseDto {
    private boolean isSuccess;
    private String message;
    private ResourceFileDto results;

    public static class ResourceFileDto {
        private String filePath;
        private String fileName;
        private String content;
    }
}