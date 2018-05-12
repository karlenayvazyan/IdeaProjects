package am.ak.example;

import junit.framework.TestCase;

import java.util.concurrent.Semaphore;

/**
 * Created by karlen on 9/1/16.
 */
public class SemDemo extends TestCase {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);

        new IncThread("a", semaphore);
        new DecThread("b", semaphore);
    }
}

class Shared {
    static int count = 0;
}

class IncThread implements Runnable {

    String name;
    Semaphore semaphore;

    public IncThread(String name, Semaphore semaphore) {
        this.name = name;
        this.semaphore = semaphore;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Зaпycк потока " + name);
        try {
            System.out.println("Пoтoк " + name + " ожидает разрешения");
            semaphore.acquire();
            System.out.println("Пoтoк" + name + " получает р азрешение ");
            for (int i = 0; i < 5; i++) {
                Shared.count++;
                System.out.println(name + " : " + Shared.count);
                Thread.sleep(10);
            }
        } catch (InterruptedException ехс) {
            System.out.println(ехс);
        }
        System.out.println("Пoтoк" + name + " освобождает разрешение ");
        semaphore.release();
    }
}

class DecThread implements Runnable {

    String name;
    Semaphore semaphore;

    public DecThread(String name, Semaphore semaphore) {
        this.name = name;
        this.semaphore = semaphore;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Зaпycк потока " + name);
        try {
            System.out.println("Пoтoк" + name + " ожидает разрешения");
            semaphore.acquire();
            System.out.println("Пoтoк" + name + " получает разрешение");
            for (int i = 0; i < 5; i++) {
                Shared.count--;
                System.out.println(name + " : " + Shared.count);
                Thread.sleep(10);
            }
        } catch (InterruptedException ехс) {
            System.out.println(ехс);
        }
        System.out.println("Пoтoк" + name + " освобождает разрешение");
        semaphore.release();
    }
}
