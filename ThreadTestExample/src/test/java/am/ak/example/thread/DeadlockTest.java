package am.ak.example.thread;

import junit.framework.TestCase;

/**
 * Created by karlen on 8/30/16.
 */
public class DeadlockTest extends TestCase {
    A a = new A();
    B b = new B();

    public void testDeadlock() {
        Thread.currentThread().setName("main thread");
        new Thread(() -> {
            b.bar(a);
            System.out.println("Haзaд в другой поток");
        }).start();

        a.foo(b);
        System.out.println("Haзaд в главный поток");
    }
}

class A {

    synchronized void foo(B b) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " вошел в метод A . f oo ( ) ");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println(name + " пытается вызвать метод B.last()");
        b.last();
    }

    synchronized void last() {
        System.out.println("Bметоде A.last()");
    }
}

class B {
    synchronized void bar(A a) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " вошел в метод A.foo()");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println(name + " пытается вызвать метод A.last()");
        a.last();
    }

    synchronized void last() {
        System.out.println("Bметоде B.last()");
    }
}
