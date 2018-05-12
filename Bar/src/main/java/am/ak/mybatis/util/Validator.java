package am.ak.mybatis.util;

import java.util.Collection;

/**
 * Created by karlen on 4/30/15.
 */
public class Validator {

    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean isEmpty(String[] str) {
        return str == null || str.length == 0;
    }

    public static boolean isEmpty(Collection<?> col) {
        return col == null || col.size() == 0;
    }
}
