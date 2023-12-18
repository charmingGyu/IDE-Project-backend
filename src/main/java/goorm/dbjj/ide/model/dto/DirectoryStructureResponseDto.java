package goorm.dbjj.ide.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({"isSuccess", "message", "results"})
public class DirectoryStructureResponseDto {
    private boolean isSuccess;
    private String message;
    private List<ResourceDTO> results;

    public static class ResourceDTO {
        private String id;
        private String name;
        @JsonInclude
        private List<ResourceDTO> children;
    }
}