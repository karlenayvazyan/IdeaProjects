package am.ak.example;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by karlen on 9/1/16.
 */
public class BarDemo {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> System.out.println("Бapьep достигнут"));

        System.out.println(" Зaпycк потоков ");

        new MyNewThread(cyclicBarrier, "A");
        new MyNewThread(cyclicBarrier, "b");
        new MyNewThread(cyclicBarrier, "c");
        new MyNewThread(cyclicBarrier, "d");
        new MyNewThread(cyclicBarrier, "e");
        new MyNewThread(cyclicBarrier, "f");
        new MyNewThread(cyclicBarrier, "g");
        new MyNewThread(cyclicBarrier, "h");
//        new MyNewThread(cyclicBarrier, "i");
    }
}

class MyNewThread {

    public MyNewThread(CyclicBarrier cyclicBarrier, String name) {
        new Thread(() -> {

            System.out.println(name);

            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();
    }
}