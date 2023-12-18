package goorm.dbjj.ide.model.dto;

import lombok.*;

@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileSaveRequestDto {
    private Long projectId;
    private String directory;
    private String fileName;
    private String content;
}
