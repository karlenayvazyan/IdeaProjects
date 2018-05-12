import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.*;

/**
 * Created by karlen on 20.02.16.
 */
public class FileCopy {

    private static final String PATH = "/home/karlen/books/besy_[tfile.ru]";

    public static void main(String[] args) {
        copy(PATH);
    }

    private static void copy(String path) {
        File mainFilePath = new File(path);

        for (File file : mainFilePath.listFiles()) {
            String filePath = path + File.separator + file.getName();
            if (file.isDirectory()) {
                copy(filePath);
            } else {
                move(filePath, file.getName());
            }
        }
    }

    private static void move(String source, String fileName) {
        try {
            Files.move(Paths.get(source), Paths.get(PATH + File.separator + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
