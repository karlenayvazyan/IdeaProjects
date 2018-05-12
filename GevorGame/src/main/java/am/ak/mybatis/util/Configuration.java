package am.ak.mybatis.util;

import am.ak.mybatis.data.model.lcp.ConfigData;

import java.util.Properties;

/**
 * Created by karlen on 03.05.16.
 */
public class Configuration {

    private Properties properties;

    public Configuration(Properties properties) {
        this.properties = properties;
    }

    public String get(ConfigData configData) {
        return properties.getProperty(configData.getKey());
    }
}
