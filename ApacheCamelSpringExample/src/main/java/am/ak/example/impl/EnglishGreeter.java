package am.ak.example.impl;

import am.ak.example.Greeter;

/**
 * Created by karlen on 19.12.15.
 */
public class EnglishGreeter implements Greeter {

    public String sayHello() {
        return "Davs " + System.getProperty("user.name");
    }
}
