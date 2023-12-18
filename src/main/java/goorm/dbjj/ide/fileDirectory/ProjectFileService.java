package goorm.dbjj.ide.fileDirectory;
import goorm.dbjj.ide.storageManager.model.Resource;

public interface ProjectFileService {
    void initProjectDirectory(String projectId);

    void createDirectory(String projectId, String path);

    Resource loadProjectDirectory(String projectId);

    void moveFile(String projectId, String oldPath, String newPath, String fullPath);

    void saveFile(String projectId, String filePath, String content);

    Resource loadFile(String projectId, String filePath);

    void deleteFile(String projectId, String filePath);


}
