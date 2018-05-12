package am.ak.question.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by karlen on 13.03.16.
 */
public class LevonQyal {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("km");
            }
        });
        thread.start();
    }
}
