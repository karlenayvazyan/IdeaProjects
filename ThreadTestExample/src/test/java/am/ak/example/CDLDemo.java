package am.ak.example;

import java.util.concurrent.CountDownLatch;

/**
 * Created by karlen on 9/1/16.
 */
public class CDLDemo {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(5);

        System.out.println("Зaпycк потока исполнения");

        new MyThread(countDownLatch);
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("Завершение потока исполнения");
    }
}

class MyThread {

    public MyThread(CountDownLatch countDownLatch) {
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(i);
                countDownLatch.countDown();
            }
        }).start();
    }
}
