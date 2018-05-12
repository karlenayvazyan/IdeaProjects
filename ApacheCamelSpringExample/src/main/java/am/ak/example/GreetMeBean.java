package am.ak.example;

/**
 * Created by karlen on 19.12.15.
 */
public class GreetMeBean {

    private Greeter greeter;

    public void execute() {
        String s = greeter.sayHello();
        System.out.println(s);
    }

    public void setGreeter(Greeter greeter) {
        this.greeter = greeter;
    }
}
