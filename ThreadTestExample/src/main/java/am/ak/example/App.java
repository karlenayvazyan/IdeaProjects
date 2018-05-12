package am.ak.example;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Object e = "E";
        System.out.println("E".equals(e));
        List<String> users = new ArrayList<>();
        users.add("A");
        users.add("B");
        users.add("C");
        users.add("D");

        Iterator<String> iterator = users.iterator();
        iterator.next();
        iterator.remove();
        iterator.next();
        iterator.remove();
        for (String user : users) {
            System.out.println(user);
        }
    }
}
