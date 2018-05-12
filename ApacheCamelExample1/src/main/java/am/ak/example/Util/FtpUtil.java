package am.ak.example.Util;

/**
 * Created by karlen on 19.12.15.
 */
public class FtpUtil {

    public static final String URI = "https://personal.filesanywhere.com/Views/View.aspx?Type=";
    public static final String USER_NAME= "KARLEN.AYVAZYAN";
    public static final String PASSWORD = "500a$110#A";

    public static String getPath() {
        return "ftp://" + URI + "?username=" + USER_NAME + "&password=" + PASSWORD;
    }
}
