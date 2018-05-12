package am.ak.example;

import java.util.concurrent.Exchanger;

/**
 * Created by karlen on 9/1/16.
 */
public class ExgrDemo {

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        makeString(exchanger);
        useString(exchanger);
    }

    public static void makeString(Exchanger<String> ex) {
        new Thread(() -> {
            String str = new String();
            char c = 'A';
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 5; j++) {
                    str += c++;
                }
                try {
                    str = ex.exchange(str);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        }).start();
    }

    public static void useString(Exchanger<String> ex) {
        new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                try {
                    String string = ex.exchange(new String());
                    System.out.println(string);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        }).start();
    }
}