package goorm.dbjj.ide.fileDirectory;

import static goorm.dbjj.ide.storageManager.StorageManager.RESOURCE_SEPARATOR;

import goorm.dbjj.ide.storageManager.FileIoStorageManager;
import goorm.dbjj.ide.storageManager.model.Resource;
import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Component;


@Component
public class FileIoProjectFileService implements ProjectFileService {
    private final String ROOT_DRICETORY = "/home/ubunto/efs/app";

    private String getFullPath(String projectId, String path) {
        if (StringUtils.isEmpty(path)) {
            return ROOT_DRICETORY + RESOURCE_SEPARATOR + projectId; // "/app" + "/" + projectId -> /app/projectId
        }
        return ROOT_DRICETORY + RESOURCE_SEPARATOR + projectId + path;
    }

    private final FileIoStorageManager storageManager;

    public FileIoProjectFileService(FileIoStorageManager storageManager) {
        this.storageManager = storageManager;
    }

    @Override
    public void initProjectDirectory(String projectId) {
        String directoryPath = getFullPath(projectId, "");
        storageManager.createDirectory(directoryPath);
    }

    @Override
    public void createDirectory(String projectId, String path) { // 예외처리 확인해보기
        String fullPath = getFullPath(projectId, path);
        storageManager.createDirectory(fullPath);
    }

    @Override
    public Resource loadProjectDirectory(String projectId) {
        String directoryPath = getFullPath(projectId, "");
        return storageManager.loadDirectory(directoryPath);
    }


    @Override
    public void moveFile(String projectId, String oldPath, String newPath, String fullPath) {
        String fileOldPath = getFullPath(projectId, oldPath);
        String fileNewPath = getFullPath(projectId, newPath);
        Resource resource = storageManager.loadFile(fileOldPath);
        storageManager.saveFile(fileNewPath, resource.getName(), resource.getContent());
        storageManager.deleteFile(fileOldPath);
    }

    @Override
    public void saveFile(String projectId, String filePath, String content) {
        String fullPath = getFullPath(projectId, filePath);
        storageManager.saveFile(projectId, fullPath, content);
    }

    @Override
    public Resource loadFile(String projectId, String filePath) { // 재귀로 로드 // 관심사 분리
        String fullPath = getFullPath(projectId, filePath);
        return storageManager.loadFile(fullPath);

//        return loadFileRecursive(fullPath);
    }

//    private Resource loadFileRecursive(String path) {
//        File file = new File(path);
//
//        if (file.isFile()) { // File 인 경우
//            return storageManager.loadFile(path);
//        }
//        else if (file.isDirectory()) { // Directory 인 경우
//            Resource directoryResource = storageManager.loadDirectory(path);
//            File[] subFiles = file.listFiles();
//
//            if (subFiles != null) {
//                for (File subFile : subFiles) {
//                    Resource childResource = loadFileRecursive(subFile.getAbsolutePath());
//                    directoryResource.addChild(childResource);
//                }
//            }
//            return directoryResource;
//        }
//        // File 또는 Directory가 아닌 경우 exception
//        else {
//            throw new ResourceNotFoundException("지정된 경로에 File이나 Directory가 존재하지 않음 : " + path);
//        }
//    }

    @Override
    public void deleteFile(String projectId, String filePath) {
        String fullPath = getFullPath(projectId, filePath);
        storageManager.deleteFile(fullPath);
    }
}


