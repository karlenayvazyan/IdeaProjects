package am.levon.jdbc.data.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by karlen on 8/1/15.
 */
public class ConnectionProvider {

    private static ConnectionProvider connectionProvider;

    private Connection connection;

    private String driver;

    private String url;

    private String username;

    private String password;

    private ConnectionProvider() {
        try {
            loadConfigProperties();
            init();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadConfigProperties() throws IOException {
        InputStream inputStream = ConnectionProvider.class.getClassLoader().
                getResourceAsStream("config/jdbc.properties");
        Properties properties = new Properties();
        properties.load(inputStream);

        driver = properties.getProperty("db.driver");
        url = properties.getProperty("db.url");
        username = properties.getProperty("db.username");
        password = properties.getProperty("db.password");
    }

    private void init() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        connection = DriverManager.getConnection(url, username, password);
    }

    public static ConnectionProvider getInstance() {
        if (connectionProvider == null) {
            synchronized (ConnectionProvider.class) {
                if (connectionProvider == null) {
                    connectionProvider = new ConnectionProvider();
                }
            }
        }
        return connectionProvider;
    }

    public Connection getConnection() {
        return connection;
    }
}
