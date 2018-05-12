package am.ak.question.util;

/**
 * Created by karlen on 20.02.16.
 */
public class Validator {

    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }
}
