package goorm.dbjj.ide.fileDirectory;


import goorm.dbjj.ide.model.dto.FileLoadRequestDto;
import goorm.dbjj.ide.model.dto.FileSaveRequestDto;
import goorm.dbjj.ide.storageManager.model.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ProjectFileController {

    private final FileIoProjectFileService fileIoProjectFileService;


    @GetMapping("/api/files") // 특정파일 조회
    public ResponseEntity<Resource> loadFile(@ModelAttribute FileLoadRequestDto fileLoadRequestDto) {
        Resource file = fileIoProjectFileService.loadFile(fileLoadRequestDto.getProjectId().toString(), fileLoadRequestDto.getDirectory() + "/" + fileLoadRequestDto.getFileName());
        return ResponseEntity.ok(file);
    }

    @PostMapping("/api/files")
    public ResponseEntity<?> saveFile(@RequestBody FileSaveRequestDto fileSaveRequestDto) {
        fileIoProjectFileService.saveFile(
                fileSaveRequestDto.getProjectId().toString(),
                fileSaveRequestDto.getDirectory() + "/" + fileSaveRequestDto.getFileName(),
                fileSaveRequestDto.getContent()
        );
        return ResponseEntity.ok("성공적으로 저장했습니다.");
    }

    @DeleteMapping("api/files/:projectId")
    public ResponseEntity<String> deleteFile(@PathVariable(name = "projectId") Long projectId, @RequestParam String path) {
        String fullPath = projectId + "/" + path;
        fileIoProjectFileService.deleteFile(String.valueOf(projectId), fullPath);
        return ResponseEntity.ok("삭제했습니다");
    }

    @GetMapping("api/files")
    public ResponseEntity<Resource> loadProjectDiretory(@RequestParam("projectId") Long projectId) {
        Resource directory = fileIoProjectFileService.loadProjectDirectory(projectId.toString());
        return ResponseEntity.ok(directory);
    }
}
