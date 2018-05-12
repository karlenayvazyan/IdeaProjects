package am.ak.example.thread;

/**
 * Unit test for simple App.
 */
public class AppTest {

    public static void main(String[] args) {
        Callme target = new Callme();
        Caller ob1 = new Caller(target, "Добро пожаловать");
        Caller ob2 = new Caller(target, "в синхронизиров анный");
        Caller ob3 = new Caller(target, "мир !");

        try {
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

class Callme {
    void call(String msg) {
        System.out.println("[" + msg + "]");
    }
}

class Caller implements Runnable {

    String msg;
    Callme target;
    Thread t;

    public Caller(Callme target, String msg) {
        this.msg = msg;
        this.target = target;
        this.t = new Thread(this);
        this.t.start();
    }

    public void run() {
        synchronized (target) {
            target.call(msg);
        }
    }
}