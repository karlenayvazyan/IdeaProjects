package am.ak.test;

import org.openjdk.jmh.annotations.GenerateMicroBenchmark;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        test();
    }

    @GenerateMicroBenchmark
    public static void test() {
        System.out.println("" + 1);
    }
}
