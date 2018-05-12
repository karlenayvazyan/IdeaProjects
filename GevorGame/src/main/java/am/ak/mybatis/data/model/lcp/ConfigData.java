package am.ak.mybatis.data.model.lcp;

/**
 * Created by karlen on 03.05.16.
 */
public enum ConfigData {

    FILE_PATH("file.path"),
    FILE_TEMP_PATH("file.temp.path");

    ConfigData(String key) {
        this.key = key;
    }

    private final String key;

    public String getKey() {
        return key;
    }
}
