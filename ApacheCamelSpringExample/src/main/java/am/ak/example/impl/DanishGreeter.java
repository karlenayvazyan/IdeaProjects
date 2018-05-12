package am.ak.example.impl;

import am.ak.example.Greeter;

/**
 * Created by karlen on 19.12.15.
 */
public class DanishGreeter implements Greeter {

    public String sayHello() {
        return "Hello " + System.getProperty("user.name");
    }
}
