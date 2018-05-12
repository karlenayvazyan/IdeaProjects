package am.ak.example.colHost;

/**
 * Created by karlen on 9/7/16.
 */
public interface Queue<E> {

    void add(E e);
    E remove();
    int size();
}

class CircularArrayQueue<E> implements Queue<E> {

    private E[] elements;
    private int head;
    private int tail;
    CircularArrayQueue(int capacity) {

    }
    public void add(E element) {

    }
    public E remove() {
        return null;
    }
    public int size() {
        return -1;
    }
}

class LinkedListQueue<E> implements Queue<E> {

    LinkedListQueue() {

    }
    public void add(E element) {

    }
    public E remove() {
        return null;
    }
    public int size() {
        return -1;
    }
//    private Link head;
//    private Link tail;
}