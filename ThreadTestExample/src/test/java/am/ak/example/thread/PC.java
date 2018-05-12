package am.ak.example.thread;

import junit.framework.TestCase;

public class PC extends TestCase {

    public void testPC() {
        Q q = new Q();
        producer(q);
        consumer(q);
    }

    public static void consumer(Q q) {
        new Thread(() -> {
            while (true) {
                q.get();
            }
        }).start();
    }

    public static void producer(Q q) {
        new Thread(() -> {
            int i = 0;

            while (true) {
                q.put(i++);
            }
        }).start();
    }
}

class Q {
    int n;
    boolean valueSet = false;

    synchronized int get() {
        while (!valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println("get: " + n);
        valueSet = false;
        notify();
        return n;
    }

    synchronized void put(int n) {
        while (valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        this.n = n;
        valueSet = true;
        System.out.println("put: " + n);
        notify();
    }
}
