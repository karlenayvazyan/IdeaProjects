package am.ak.example.collection;

import junit.framework.TestCase;

import java.util.*;
import java.util.stream.Stream;

/**
 * Created by karlen on 8/31/16.
 */
public class CollectionTest extends TestCase {

    public void testCollectionRemoveIf() {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.removeIf((t) -> t < 3);
        arr.forEach((item) -> System.out.print(item + ", "));
    }

    public void testHashSet() {
        TreeSet<Integer> arr = new TreeSet<>();
        arr.add(4);
        arr.add(3);
        arr.add(1);
        arr.add(2);
        arr.add(5);
        arr.subSet(1, 4).forEach((item) -> System.out.println(item));
    }
}
