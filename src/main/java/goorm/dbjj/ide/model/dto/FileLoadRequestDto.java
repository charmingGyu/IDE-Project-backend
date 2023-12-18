package goorm.dbjj.ide.model.dto;

import lombok.*;

@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileLoadRequestDto {
    private Long projectId;
    private String directory;
    private String fileName;

}
