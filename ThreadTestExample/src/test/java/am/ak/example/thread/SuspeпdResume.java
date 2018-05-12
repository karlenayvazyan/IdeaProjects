package am.ak.example.thread;

import junit.framework.TestCase;

/**
 * Created by karlen on 8/30/16.
 */
public class SuspeпdResume extends TestCase {

    public void testSuspeпdResume() {
        NewThread one = new NewThread("one");
        NewThread two = new NewThread("two");

        try {
            Thread.sleep(1000);
            one.mysuspend();
            System.out.println("stop thread one");
            Thread.sleep(1000);
            one.myresume();
            System.out.println("start thread one");
            two.mysuspend();
            System.out.println("stop thread two");
            Thread.sleep(1000);
            two.myresume();
            System.out.println("start thread two");
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        try {
            System.out.println("wait for finish threads");
            one.t.join();
            two.t.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("main thread finished");
    }
}

class NewThread implements Runnable {

    String name;
    Thread t;
    boolean suspendFlag;

    public NewThread(String name) {
        this.name = name;
        t = new Thread(this, name);
        System.out.println("New thread: " + t);
        suspendFlag = false;
        t.start();
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 15; i++) {
                System.out.println(name + ": " + i);
                Thread.sleep(200);
                synchronized (this) {
                    while (suspendFlag) {
                        wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println(name + " finished");
    }

    synchronized void mysuspend() {
        suspendFlag = true;
    }

    synchronized void myresume() {
        suspendFlag = false;
        notify();
    }
}
