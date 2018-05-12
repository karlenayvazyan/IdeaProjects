package am.ak.question.util;

/**
 * Created by karlen on 13.03.16.
 */
public final class Singleton {

    public static volatile Singleton innstance = null;

    private Singleton() {
    }

    public static Singleton getInstance(){
        if (innstance == null) {
            synchronized (Singleton.class){
                if (innstance == null){
                    innstance = new Singleton();
                }
            }
        }
        return innstance;
    }
}
