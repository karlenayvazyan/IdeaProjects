/**
 * Java Program to demonstrate how to use Lock and Condition variable in Java by * solving Producer consumer problem. Locks are more flexible way to provide * mutual exclusion and synchronization in Java, a powerful alternative of * synchronized keyword. * * @author Javin Paul
 */
public class ProducerConsumerSolutionUsingLock {
    public static void main(String[] args) {
        ProducerConsumerImpl sharedObject = new ProducerConsumerImpl();
        // creating producer and consumer threads
        Producer p = new Producer(sharedObject);
        Consumer c = new Consumer(sharedObject);
        p.start();
        c.start();
    }
}

