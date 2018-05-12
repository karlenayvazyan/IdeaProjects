package am.ak.spring.data.service;

/**
 * Created by karlen on 3/14/17.
 */
public class A {

    private static volatile PetStoreServiceImpl a;

    public static PetStoreServiceImpl getInstance() {
        if (a == null) {
            synchronized (A.class) {
                if (a == null) {
                    a = new PetStoreServiceImpl();
                }
            }
        }
        return a;
    }
}
