package am.ak.mybatis.util;

import am.ak.mybatis.data.model.lcp.ConfigData;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by karlen on 03.05.16.
 */
public class FileUtility {

    @Autowired
    private Configuration configuration;

    /**
     * Stores Image file on disk
     *
     * @param file
     * @param data
     * @throws IOException
     */
    public void storeToTemp(am.ak.mybatis.data.model.File file, byte[] data) throws IOException {
        File tempFile = new File(getTempPath(file));
        tempFile.getParentFile().mkdirs();
        FileUtils.writeByteArrayToFile(tempFile, data);
    }

    /**
     * Remove file on disk
     *
     * @param file
     */
    public void removeFromTemp(am.ak.mybatis.data.model.File file) {
        File tempFile = new File(getTempPath(file));
        tempFile.delete();
    }

    private String getTempPath(am.ak.mybatis.data.model.File file) {
        return configuration.get(ConfigData.FILE_TEMP_PATH)
                + File.separator + getTimeMilliseconds(file.getCreationDate())
                + File.separator + file.getName();
    }

    private long getTimeMilliseconds(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        return calendar.getTimeInMillis();
    }
}
