package am.gevor.game.util;

import am.gevor.game.data.model.*;
import am.gevor.game.data.mvc.model.SubCategoryFrom;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by karlen on 5/29/16.
 */
public class FileUtils {

    @Value("${file.save.directory}")
    private String directory;

    public void store(InputStream stream, String fileName, String id) throws IOException {
        OutputStream bufferedOutputStream = null;
        OutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(getFile(fileName, id));
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            FileCopyUtils.copy(stream, bufferedOutputStream);
        } finally {
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        }
    }

    public List<am.gevor.game.data.model.File> getAndStoreFiles(SubCategoryFrom subCategoryFrom, String subCategoryId) throws IOException {
        List<am.gevor.game.data.model.File> files = new ArrayList<>();
        MultipartFile fileSize1 = subCategoryFrom.getFileSize1();
        MultipartFile fileSize2 = subCategoryFrom.getFileSize2();
        MultipartFile fileSize3 = subCategoryFrom.getFileSize3();
        MultipartFile fileSize4 = subCategoryFrom.getFileSize4();
        MultipartFile fileSize5 = subCategoryFrom.getFileSize5();
        store(fileSize1.getInputStream(), fileSize1.getOriginalFilename(), subCategoryId);
        files.add(getFile(fileSize1));
        store(fileSize2.getInputStream(), fileSize2.getOriginalFilename(), subCategoryId);
        files.add(getFile(fileSize2));
        store(fileSize3.getInputStream(), fileSize3.getOriginalFilename(), subCategoryId);
        files.add(getFile(fileSize3));
        store(fileSize4.getInputStream(), fileSize4.getOriginalFilename(), subCategoryId);
        files.add(getFile(fileSize4));
        store(fileSize5.getInputStream(), fileSize5.getOriginalFilename(), subCategoryId);
        files.add(getFile(fileSize5));
        return files;
    }

    public void removeUploadedFiles(SubCategoryFrom subCategoryFrom, String subCategoryId) {
        MultipartFile fileSize1 = subCategoryFrom.getFileSize1();
        MultipartFile fileSize2 = subCategoryFrom.getFileSize2();
        MultipartFile fileSize3 = subCategoryFrom.getFileSize3();
        MultipartFile fileSize4 = subCategoryFrom.getFileSize4();
        MultipartFile fileSize5 = subCategoryFrom.getFileSize5();
        if (fileSize1 != null) {
            delete(fileSize1.getOriginalFilename(), subCategoryId);
        }
        if (fileSize2 != null) {
            delete(fileSize2.getOriginalFilename(), subCategoryId);
        }
        if (fileSize3 != null) {
            delete(fileSize3.getOriginalFilename(), subCategoryId);
        }
        if (fileSize4 != null) {
            delete(fileSize4.getOriginalFilename(), subCategoryId);
        }
        if (fileSize5 != null) {
            delete(fileSize5.getOriginalFilename(), subCategoryId);
        }
    }

    private am.gevor.game.data.model.File getFile(MultipartFile file) {
        am.gevor.game.data.model.File tempFile = new am.gevor.game.data.model.File();
        tempFile.setContentType(file.getContentType());
        tempFile.setName(file.getOriginalFilename());
        tempFile.setSize(file.getSize());
        return tempFile;
    }

    public void delete(String name, String id) {
        File diskFile = getFile(name, id);
        if (diskFile != null && diskFile.exists()) {
            diskFile.delete();
        }
    }

    private File getFile(String name, String id) {
        File file = new File(getPath(name, id));
        file.getParentFile().mkdirs();
        return file;
    }

    private String getPath(String name, String id) {
        return directory + id + File.separator + name;
    }
}
